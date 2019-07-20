import java.util.*; 

interface Stack
{
    
}


class Undo implements Stack
{
    public static char operation;
}

class Board
{
   public static  int max_rows=20;
  public static  int max_cols=20;
public static char[][] screen=new char[20][20];
    public static int[] flag=new int[20];
    
    Board()
    {
int i,j;
        for(i=0;i<20;i++)
        {
        flag[i]=0;
        }
}


void generate_board(){
int i,j;

for(i=0;i<max_rows;i++)
{for(j=0;j<max_cols;j++)
{
 
    if(j==max_cols-1||j==0)
screen[i][j]='*';
 
 else if(i==0||i==max_rows-1)
     screen[i][j]='*';
}
}
}
    
    
public static void display()
{
int i,j;

for(i=0;i<max_rows;i++)
{for(j=0;j<max_cols;j++)
{System.out.print(screen[i][j]);

}
System.out.println();
}
}
    
    
   public static  void delete_row()
    {
    
        int i,j;
for(i=0;i<20;i++)
{
    if(flag[i]==18)
    {
        flag[i]=0;
        for(j=i;j>1;j--)
        { screen[j]=screen[j-1];
         flag[j]=flag[j-1];
        }
  
    }
}
        
    }

}

class Point 
{
    int x=1;
    int y=1;
    Point(int a,int b)
    {
        x=a;
        y=b;
    }
    Point()
    {
        x=1;
        y=1;
    }
}

class Shapes 
{
int version;
    int max_cols=20;
    int max_rows=20;

Point shape[];

Shapes()
{
shape=new Point[4];


}

void cordinates()
{

}
    int update_flag()
    {
        

      Board.flag[shape[0].x]+=1;
       Board.flag[shape[1].x]+=1;
         Board.flag[shape[2].x]+=1;
         Board.flag[shape[3].x]+=1;
        
        if(Board.flag[1]==1)
            return 1;
        
        Board.delete_row();
        
        return 0;
    }

int check_bottom()
{
   
    
    if(shape[0].x==max_rows-1||shape[1].x==max_rows-2||shape[2].x==max_rows-2||shape[3].x==max_rows-2)
        return 1;
   
  else if(Board.screen[shape[0].x+1][shape[0].y]=='#'||Board.screen[shape[1].x+1][shape[1].y]=='#'||Board.screen[shape[2].x+1][shape[2].y]=='#'||Board.screen[shape[3].x+1][shape[3].y]=='#')
        return 1;
    
    else
        return 0;
}
    
    int check_left()
{
   
    
   
   
 if(Board.screen[shape[0].x][shape[0].y-1]=='#'||Board.screen[shape[1].x][shape[1].y-1]=='#'||Board.screen[shape[2].x][shape[2].y-1]=='#'||Board.screen[shape[3].x][shape[3].y-1]=='#')
        return 1;
    
    else
        return 0;
}
    
        int check_right()
{
   
    
   
   
 if(Board.screen[shape[0].x][shape[0].y+1]=='#'||Board.screen[shape[1].x][shape[1].y+1]=='#'||Board.screen[shape[2].x][shape[2].y+1]=='#'||Board.screen[shape[3].x][shape[3].y+1]=='#')
        return 1;
    
    else
        return 0;
}
    

void select_version(){}

void left(){

if(shape[0].y==1||shape[1].y==1||shape[2].y==1||shape[3].y==1)
return;

shape[0].y=shape[0].y-1;


shape[1].y=shape[1].y-1;


shape[2].y=shape[2].y-1;

shape[3].y=shape[3].y-1;

}
void right(){


if(shape[0].y==18||shape[1].y==18||shape[2].y==18||shape[3].y==18)
return;

shape[0].y=shape[0].y+1;


shape[1].y=shape[1].y+1;


shape[2].y=shape[2].y+1;

shape[3].y=shape[3].y+1;
}
void bottom(){


if(shape[0].x==18||shape[1].x==18||shape[2].x==18||shape[3].x==18)
return;

shape[0].x=shape[0].x+1;


shape[1].x=shape[1].x+1;


shape[2].x=shape[2].x+1;

shape[3].x=shape[3].x+1;

}
    
    void up(){


if(shape[0].x==1||shape[1].x==1||shape[2].x==1||shape[3].x==1)
return;

shape[0].x=shape[0].x-1;


shape[1].x=shape[1].x-1;


shape[2].x=shape[2].x-1;

shape[3].x=shape[3].x-1;

}


void generate_shape()
{


Board.screen[shape[0].x][shape[0].y]='#';
Board.screen[shape[1].x][shape[1].y]='#';
Board.screen[shape[2].x][shape[2].y]='#';
Board.screen[shape[3].x][shape[3].y]='#';
}


void remove_prevshape()
{


Board.screen[shape[0].x][shape[0].y]=' ';
Board.screen[shape[1].x][shape[1].y]=' ';
Board.screen[shape[2].x][shape[2].y]=' ';
Board.screen[shape[3].x][shape[3].y]=' ';
}


    
    int check_boundary(int x,int y)
    {
       if(x==Board.max_rows-1||x==0)
           return 0;
        else if(y==Board.max_cols-1||y==0)
            return 0;
        else
            return 1;
    }


}


class Stick extends Shapes
{

int col;
Stick(){
version=1;
random_generate();
}


void random_generate()
{

Random rand = new Random(); 
 int rand_int1 = rand.nextInt(max_cols-1); 
col=rand_int1;
 if(col==0)
 {
random_generate();
 }
 
 

 
}

void cordinates()
{
shape[0]=new Point(1,col);
shape[1]=new Point(2,col);
shape[2]=new Point(3,col);
shape[3]=new Point(4,col);
}


void select_version()
{
if(version==1)
{version=2;
v2();
}

else
{
version=1;
v1();
}
}


void v1()
{
int t=0;

if(check_boundary(shape[0].x,shape[0].y)==1)
{

if(check_boundary(shape[1].x+1,shape[1].y-1)==1)
{

if(check_boundary(shape[2].x+2,shape[2].y-2)==1)
{
if(check_boundary(shape[3].x+3,shape[3].y-3)==1)
{
t=1;
}
}
}
}

if(t==1)
{

shape[0].x=shape[0].x;
shape[0].y=shape[0].y;

shape[1].x=shape[1].x+1;
shape[1].y=shape[1].y-1;

shape[2].x=shape[2].x+2;
shape[2].y=shape[2].y-2;

shape[3].x=shape[3].x+3;
shape[3].y=shape[3].y-3;
}
else
version=2;

}

void v2()
{
int t=0;

if(check_boundary(shape[0].x,shape[0].y)==1)
{

if(check_boundary(shape[1].x-1,shape[1].y+1)==1)
{

if(check_boundary(shape[2].x-2,shape[2].y+2)==1)
{
if(check_boundary(shape[3].x-3,shape[3].y+3)==1)
{
t=1;
}
}
}
}

if(t==1)
{

shape[0].x=shape[0].x;
shape[0].y=shape[0].y;

shape[1].x=shape[1].x-1;
shape[1].y=shape[1].y+1;

shape[2].x=shape[2].x-2;
shape[2].y=shape[2].y+2;

shape[3].x=shape[3].x-3;
shape[3].y=shape[3].y+3;
}
else
version=1;

}





}





class Square extends Shapes
{
int col;

Square(){
version=1;
random_generate();
}


void random_generate()
{

Random rand = new Random(); 
 int rand_int1 = rand.nextInt(max_cols-1); 
 col=rand_int1;
 if(col==0||col==max_cols-2)
 {
random_generate();
 }
 
 
}

void cordinates()
{
shape[0]=new Point(1,col);
shape[1]=new Point(1,col+1);
shape[2]=new Point(2,col);
shape[3]=new Point(2,col+1);
}


void select_version()
{
    
}



}


class L extends Shapes
{
int col;
L(){
version=1;
random_generate();
}


void random_generate()
{

Random rand = new Random(); 
 int rand_int1 = rand.nextInt(max_cols-1); 
 col=rand_int1;
 
 if(col==0||col==max_cols-2)
 {
random_generate();
 }

 
}

void cordinates()
{

shape[0]=new Point(1,col);
shape[1]=new Point(2,col);
shape[2]=new Point(3,col);
shape[3]=new Point(3,col+1);


}


void select_version()
{
if(version==1)
{version=2;
v2();
return;
}

else if(version==2)
{
version=3;
v3();
return;
}

else if(version==3)
{
version=4;
v4();
return;
}

else if(version==4)
{
version=1;
v1();
return;
}
}


void v1()
{


int t=0;

if(check_boundary(shape[0].x-2,shape[0].y)==1)
{

if(check_boundary(shape[1].x-1,shape[1].y-1)==1)
{

if(check_boundary(shape[2].x,shape[2].y-2)==1)
{
if(check_boundary(shape[3].x+1,shape[3].y-1)==1)
{
t=1;
}
}
}
}

if(t==1)
{

shape[0].x=shape[0].x-2;
shape[0].y=shape[0].y;

shape[1].x=shape[1].x-1;
shape[1].y=shape[1].y-1;

shape[2].x=shape[2].x;
shape[2].y=shape[2].y-2;

shape[3].x=shape[3].x+1;
shape[3].y=shape[3].y-1;

}
else
version=4;


}

void v2()
{


int t=0;

if(check_boundary(shape[0].x,shape[0].y+2)==1)
{

if(check_boundary(shape[1].x-1,shape[1].y+1)==1)
{

if(check_boundary(shape[2].x-2,shape[2].y)==1)
{
if(check_boundary(shape[3].x-1,shape[3].y-1)==1)
{
t=1;
}
}
}
}

if(t==1)
{

shape[0].x=shape[0].x;
shape[0].y=shape[0].y+2;

shape[1].x=shape[1].x-1;
shape[1].y=shape[1].y+1;

shape[2].x=shape[2].x-2;
shape[2].y=shape[2].y;

shape[3].x=shape[3].x-1;
shape[3].y=shape[3].y-1;

}
else
version=1;



}


void v3()
{

int t=0;

if(check_boundary(shape[0].x+2,shape[0].y)==1)
{

if(check_boundary(shape[1].x+1,shape[1].y+1)==1)
{

if(check_boundary(shape[2].x,shape[2].y+2)==1)
{
if(check_boundary(shape[3].x-1,shape[3].y+1)==1)
{
t=1;
}
}
}
}

if(t==1)
{

shape[0].x=shape[0].x+2;
shape[0].y=shape[0].y;

shape[1].x=shape[1].x+1;
shape[1].y=shape[1].y+1;

shape[2].x=shape[2].x;
shape[2].y=shape[2].y+2;

shape[3].x=shape[3].x-1;
shape[3].y=shape[3].y+1;
}
else
version=2;


}


void v4()
{


int t=0;

if(check_boundary(shape[0].x,shape[0].y-2)==1)
{

if(check_boundary(shape[1].x+1,shape[1].y-1)==1)
{

if(check_boundary(shape[2].x+2,shape[2].y)==1)
{
if(check_boundary(shape[3].x+1,shape[3].y+1)==1)
{
t=1;
}
}
}
}

if(t==1)
{

shape[0].x=shape[0].x;
shape[0].y=shape[0].y-2;

shape[1].x=shape[1].x+1;
shape[1].y=shape[1].y-1;

shape[2].x=shape[2].x+2;
shape[2].y=shape[2].y;

shape[3].x=shape[3].x+1;
shape[3].y=shape[3].y+1;

}
else
version=3;


}



}



class T extends Shapes
{
int col;
T(){
version=1;
random_generate();
}


void random_generate()
{

Random rand = new Random(); 
 int rand_int1 = rand.nextInt(max_cols-3); 
 col=rand_int1;
 
 if(col==0||col==1||col==max_cols-2)
 {
random_generate();
 }
 
 
}

void cordinates()
{

shape[0]=new Point(1,col+1);
shape[1]=new Point(2,col);
shape[2]=new Point(2,col+1);
shape[3]=new Point(2,col+2);

}


void select_version()
{
if(version==1)
{version=2;
v2();
}

else if(version==2)
{
version=3;
v3();
}

else if(version==3)
{
version=4;
v4();
}

else if(version==4)
{
version=1;
v1();
}
}


void v1()
{


int t=0;

if(check_boundary(shape[0].x-1,shape[0].y)==1)
{

if(check_boundary(shape[1].x-1,shape[1].y-2)==1)
{

if(check_boundary(shape[2].x,shape[2].y-1)==1)
{
if(check_boundary(shape[3].x+1,shape[3].y)==1)
{
t=1;
}
}
}
}

if(t==1)
{

shape[0].x=shape[0].x-1;
shape[0].y=shape[0].y;

shape[1].x=shape[1].x-1;
shape[1].y=shape[1].y-2;

shape[2].x=shape[2].x;
shape[2].y=shape[2].y-1;

shape[3].x=shape[3].x+1;
shape[3].y=shape[3].y;
}

else
version=4;



}

void v2()
{


int t=0;

if(check_boundary(shape[0].x+1,shape[0].y)==1)
{

if(check_boundary(shape[1].x-1,shape[1].y)==1)
{

if(check_boundary(shape[2].x,shape[2].y-1)==1)
{
if(check_boundary(shape[3].x+1,shape[3].y-2)==1)
{
t=1;
}
}
}
}

if(t==1)
{

shape[0].x=shape[0].x+1;
shape[0].y=shape[0].y;

shape[1].x=shape[1].x-1;
shape[1].y=shape[1].y;

shape[2].x=shape[2].x;
shape[2].y=shape[2].y-1;

shape[3].x=shape[3].x+1;
shape[3].y=shape[3].y-2;

}
else
version=1;



}


void v3()
{


int t=0;

if(check_boundary(shape[0].x,shape[0].y)==1)
{

if(check_boundary(shape[1].x,shape[1].y)==1)
{

if(check_boundary(shape[2].x-1,shape[2].y+1)==1)
{
if(check_boundary(shape[3].x-2,shape[3].y+2)==1)
{
t=1;
}
}
}
}

if(t==1)
{

shape[0].x=shape[0].x;
shape[0].y=shape[0].y;

shape[1].x=shape[1].x;
shape[1].y=shape[1].y;

shape[2].x=shape[2].x-1;
shape[2].y=shape[2].y+1;

shape[3].x=shape[3].x-2;
shape[3].y=shape[3].y+2;
}
else
version=2;


}


void v4()
{



int t=0;

if(check_boundary(shape[0].x,shape[0].y)==1)
{

if(check_boundary(shape[1].x+2,shape[1].y+2)==1)
{

if(check_boundary(shape[2].x+1,shape[2].y+1)==1)
{
if(check_boundary(shape[3].x,shape[3].y)==1)
{
t=1;
}
}
}
}

if(t==1)
{

shape[0].x=shape[0].x;
shape[0].y=shape[0].y;

shape[1].x=shape[1].x+2;
shape[1].y=shape[1].y+2;

shape[2].x=shape[2].x+1;
shape[2].y=shape[2].y+1;

shape[3].x=shape[3].x;
shape[3].y=shape[3].y;
}
else
version=3;
}
}


class Shape5 extends Shapes
{

int col;
Shape5(){
version=1;
random_generate();
}


void random_generate()
{

Random rand = new Random(); 
 int rand_int1 = rand.nextInt(max_cols-1); 
 col=rand_int1;
 if(col==0||col==max_cols-2)
 {
random_generate();
 }

 
}

void cordinates()
{

shape[0]=new Point(1,col);
shape[1]=new Point(2,col);
shape[2]=new Point(2,col+1);
shape[3]=new Point(3,col+1);

}

void select_version()
{
if(version==1)
{version=2;
v2();
}

else if(version==2)
{
version=3;
v3();
}

else if(version==3)
{
version=4;
v4();
}

else if(version==4)
{
version=1;
v1();
}
}


void v1()
{


int t=0;

if(check_boundary(shape[0].x,shape[0].y)==1)
{

if(check_boundary(shape[1].x+1,shape[1].y-1)==1)
{

if(check_boundary(shape[2].x,shape[2].y)==1)
{
if(check_boundary(shape[3].x+1,shape[3].y-1)==1)
{
t=1;
}
}
}
}

if(t==1)
{
shape[0].x=shape[0].x;
shape[0].y=shape[0].y;

shape[1].x=shape[1].x+1;
shape[1].y=shape[1].y-1;

shape[2].x=shape[2].x;
shape[2].y=shape[2].y;

shape[3].x=shape[3].x+1;
shape[3].y=shape[3].y-1;

}
else
version=4;


}

void v2()
{

int t=0;

if(check_boundary(shape[0].x,shape[0].y+2)==1)
{

if(check_boundary(shape[1].x-1,shape[1].y+1)==1)
{

if(check_boundary(shape[2].x,shape[2].y)==1)
{
if(check_boundary(shape[3].x-1,shape[3].y-1)==1)
{
t=1;
}
}
}
}

if(t==1)
{

shape[0].x=shape[0].x;
shape[0].y=shape[0].y+2;

shape[1].x=shape[1].x-1;
shape[1].y=shape[1].y+1;

shape[2].x=shape[2].x;
shape[2].y=shape[2].y;

shape[3].x=shape[3].x-1;
shape[3].y=shape[3].y-1;
}
else
version=1;




}


void v3()
{


int t=0;

if(check_boundary(shape[0].x+1,shape[0].y)==1)
{

if(check_boundary(shape[1].x,shape[1].y+1)==1)
{

if(check_boundary(shape[2].x,shape[2].y)==1)
{
if(check_boundary(shape[3].x+1,shape[3].y+1)==1)
{
t=1;
}
}
}
}

if(t==1)
{

shape[0].x=shape[0].x+1;
shape[0].y=shape[0].y;

shape[1].x=shape[1].x;
shape[1].y=shape[1].y+1;

shape[2].x=shape[2].x;
shape[2].y=shape[2].y;

shape[3].x=shape[3].x+1;
shape[3].y=shape[3].y+1;
}
else
version=2;


}


void v4()
{




int t=0;

if(check_boundary(shape[0].x-1,shape[0].y-2)==1)
{

if(check_boundary(shape[1].x,shape[1].y-1)==1)
{

if(check_boundary(shape[2].x,shape[2].y)==1)
{
if(check_boundary(shape[3].x-1,shape[3].y+1)==1)
{
t=1;
}
}
}
}

if(t==1)
{
shape[0].x=shape[0].x-1;
shape[0].y=shape[0].y-2;

shape[1].x=shape[1].x;
shape[1].y=shape[1].y-1;

shape[2].x=shape[2].x;
shape[2].y=shape[2].y;

shape[3].x=shape[3].x-1;
shape[3].y=shape[3].y+1;
}
else
version=3;



}




}

public class Tetris
{
    
    int shape_no;
 
    
    
  
    void clearscreen()
    {
        try{
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        }
        catch(Exception e)
        {
            
        }
    }

    
   void random_generate()
{
Random rand = new Random(); 
 int rand_int1 = rand.nextInt(5); 
 shape_no=rand_int1;
 
}   
 
    
    
public static void main(String args[])
{
    
    char ch;
Tetris T=new Tetris();
    Board b=new Board();
    
            
        Undo u[]=new Undo[10];
        Undo r[]=new Undo[10];
        
      
        for(int i=0;i<10;i++)
        {
            u[i]=new Undo();
            r[i]=new Undo();
        }
        int undosize=0,redosize=0;
    
 T.random_generate();
    Shapes s=new Shapes();
    Shapes s1=new Shapes();
    
    
    int over=0;
    
    T.clearscreen();
    
    if(T.shape_no==0)
    { s=new Stick();
     s1=new Stick();
     
    }
   else if(T.shape_no==1)
   {s=new Square();
    s1=new Square();
   }
   else if(T.shape_no==2)
   { s=new L();
    s1=new L();
   }
     else if(T.shape_no==3)
     {s=new T();
      s1=new T();
      
     }
     else
     {
     s=new Shape5();
       s1=new Shape5();   
     }
 
    
      s.cordinates();
        s1=s;
     b.generate_board();
    s.generate_shape();
    s1.generate_shape();
   
        b.display();
    s.remove_prevshape();
    s1.remove_prevshape();
    
   Scanner sc=new Scanner(System.in);
    char move;

    
    move=sc.next().charAt(0);
    T.clearscreen();
    int fixed=0;
    
    while(true)
    {
     fixed=0;
        over=0;
        ch=move;
        if(move=='l')
        {
          
            if(s1.check_left()==1)
            {
                fixed=1;
                  if(s1.update_flag()==1)
                over=1;
                s.remove_prevshape();
                
                
            }
            else
            {
            s.left();
            s1=s;

       s.generate_shape();
        s1.generate_shape(); 
        
       b.display();

            
          s.remove_prevshape(); 
                
            
                
            }
   
        }
        
       else if(move=='r')
       {
          
          if(s.check_right()==1)
          {
              fixed=1;
                if( s1.update_flag()==1)
                   over=1;
              s.remove_prevshape();
          }
           
           else
           {
           s.right();
           s1=s;
 
       s.generate_shape();
           s1.generate_shape();
            b.display();
           
          s.remove_prevshape();
               
              
           }
  
           
       }
        
          
       else if(move=='w')
       {
          
        
           s.up();
           s1=s;
 
       s.generate_shape();
           s1.generate_shape();
            b.display();
           
          s.remove_prevshape();
           s1.remove_prevshape();
               
             
           
       }
        
        else if(move=='b')
        {
           
       if(s1.check_bottom()==1)
       {
           fixed=1;
             if( s1.update_flag()==1)
       over=1;
           s.remove_prevshape();
           
           
       }
            else
            {
            s.bottom();  
            s1=s;
 
       s.generate_shape();
            s1.generate_shape();
            
               b.display();
                s.remove_prevshape(); 
                
           
          
        
            }
     
           
          }
        
     else if(move=='c')       
     {s.select_version();
      s1=s;
      //s1.select_version();

       s.generate_shape();
       s1.generate_shape();
 
        b.display();
        
       
          s.remove_prevshape();
       s1.remove_prevshape();
     }
    
        else if(move=='u')
        {
               
            
          
            
            
            
        }
        
    
 else if(move=='o')
 {
     
 }
         
         if(fixed==1)
        {
             
            undosize=0;
        
     s=s1;
 
                if(over==1)
                    break;
  
       s.generate_shape();
       s1.generate_shape();
             
        
T.random_generate();
    
    if(T.shape_no==0)
    { s=new Stick();
     s1=new Stick();
    }
   else if(T.shape_no==1)
   { s=new Square();
     s1=new Square();
   }
   else if(T.shape_no==2)
   {s=new L();
    s1=new L();
   }
     else if(T.shape_no==3)
     {s=new T();
      s1=new T();
     }
     else
     { s=new Shape5();
      s1=new Shape5();
     }
 

        s.cordinates(); 
 
        s1=s; 
 
         
       s.generate_shape();
                   s1.generate_shape();

        b.display();
              s.remove_prevshape();
 
      s1.remove_prevshape();
       
        }
    
       move=sc.next().charAt(0);
           T.clearscreen();
   
    
            
        
       
    }
    
    System.out.println("GAME OVER");

}
}
