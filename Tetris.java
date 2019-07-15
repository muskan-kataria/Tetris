import java.util.*; 

class Board
{
char[][] screen=new char[40][40];

void generate_board(){
int i,j;

for(i=0;i<40;i++)
{for(j=0;j<40;j++)
{if(j==39||j==0)
screen[i][j]='|';
 
 else if(i==0||i==39)
     screen[i][j]='-';
 
 else 
     screen[i][j]=' ';

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

class Shapes extends Board
{
int version;

Point shape[];

Shapes()
{
shape=new Point[4];
}

void cordinates()
{

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


if(shape[0].y==38||shape[1].y==38||shape[2].y==38||shape[3].y==38)
return;

shape[0].y=shape[0].y+1;


shape[1].y=shape[1].y+1;


shape[2].y=shape[2].y+1;

shape[3].y=shape[3].y+1;
}
void bottom(){


if(shape[0].x==38||shape[1].x==38||shape[2].x==38||shape[3].x==38)
return;

shape[0].x=shape[0].x+1;


shape[1].x=shape[1].x+1;


shape[2].x=shape[2].x+1;

shape[3].x=shape[3].x+1;

}


void generate_shape()
{



screen[shape[0].x][shape[0].y]='#';
screen[shape[1].x][shape[1].y]='#';
screen[shape[2].x][shape[2].y]='#';
screen[shape[3].x][shape[3].y]='#';
}



void display()
{
int i,j;
for(i=0;i<40;i++)
{for(j=0;j<40;j++)
{System.out.print(screen[i][j]);

}
System.out.println();}
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
 int rand_int1 = rand.nextInt(40); 
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



shape[0].x=shape[0].x;
shape[0].y=shape[0].y;

shape[1].x=shape[1].x+1;
shape[1].y=shape[1].y-1;

shape[2].x=shape[2].x+2;
shape[2].y=shape[2].y-2;

shape[3].x=shape[3].x+3;
shape[3].y=shape[3].y-3;

}

void v2()
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
 int rand_int1 = rand.nextInt(39); 
 col=rand_int1;
 if(col==0||col==38)
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
 int rand_int1 = rand.nextInt(39); 
 col=rand_int1;
 
 if(col==0||col==38)
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


shape[0].x=shape[0].x-2;
shape[0].y=shape[0].y;

shape[1].x=shape[1].x-1;
shape[1].y=shape[1].y-1;

shape[2].x=shape[2].x;
shape[2].y=shape[2].y-2;

shape[3].x=shape[3].x+1;
shape[3].y=shape[3].y-1;




}

void v2()
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


void v3()
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


void v4()
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
 int rand_int1 = rand.nextInt(39); 
 col=rand_int1;
 
 if(col==0||col==1||col==38)
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


shape[0].x=shape[0].x-1;
shape[0].y=shape[0].y;

shape[1].x=shape[1].x-1;
shape[1].y=shape[1].y-2;

shape[2].x=shape[2].x;
shape[2].y=shape[2].y-1;

shape[3].x=shape[3].x+1;
shape[3].y=shape[3].y;




}

void v2()
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


void v3()
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


void v4()
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
 int rand_int1 = rand.nextInt(39); 
 col=rand_int1;
 if(col==0||col==38)
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


shape[0].x=shape[0].x;
shape[0].y=shape[0].y;

shape[1].x=shape[1].x+1;
shape[1].y=shape[1].y-1;

shape[2].x=shape[2].x;
shape[2].y=shape[2].y;

shape[3].x=shape[3].x+1;
shape[3].y=shape[3].y-1;




}

void v2()
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


void v3()
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


void v4()
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




}

public class Tetris
{
    
    int shape_no;

    
   void random_generate()
{
Random rand = new Random(); 
 int rand_int1 = rand.nextInt(5); 
 shape_no=rand_int1;
 
}    
    
    
public static void main(String args[])
{
Tetris T=new Tetris();
    
 T.random_generate();
    Shapes s=new Shapes();
    
    if(T.shape_no==0)
    { s=new Stick();
     
    }
   else if(T.shape_no==1)
     s=new Square();
   else if(T.shape_no==2)
         s=new L();
     else if(T.shape_no==3)
         s=new T();
     else
     s=new Shape5();
 
    
      s.cordinates();
     s.generate_board();
    s.generate_shape();
   
        s.display();
    
   Scanner sc=new Scanner(System.in);
    char move;

    
    move=sc.next().charAt(0);
    
    while(move!='x')
    {
        
        if(move=='l')
            s.left();
        
       else if(move=='r')
            s.right();
        
        else if(move=='b')
            s.bottom();  
        
     else if(move=='c')       
   s.select_version();
         
          s.generate_board();
         s.generate_shape();
  
        s.display();
     
       move=sc.next().charAt(0);
         
        
       
    }

}
}