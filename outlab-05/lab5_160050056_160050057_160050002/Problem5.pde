// BOUNCING BALLS Physics Simulation
// Click anywhere to apply an impulse to the neighbouring balls


final float floor_y=310, up_y=5; // y-constraints
final float left_x=5, right_x=635; // x-constraints
final int N=50; // number of balls
final float g=20; // acceleration due to gravity
final float e=0.6; // coefficient of restitution
final float delta_t=0.06; // time interval
final float J=100; // impulse
float[] pos_x=new float[N];
float[] pos_y=new float[N];
float[] vel_x=new float[N];
float[] vel_y=new float[N];
boolean click=false;
float click_x, click_y;

void setup() {
  size(640, 360);
  for (int i=0; i<N; ++i) {
    vel_x[i]=0.0002; 
    vel_y[i]=0.0002;
    pos_x[i]=(right_x-left_x)/N*i+left_x;
    pos_y[i]=50;
  }
  background(0);
  stroke(255,255,255);
  line(0,floor_y,640,floor_y);
}
void draw() {
  background(0);
  line(0,floor_y,640,floor_y);
  // update positions and velocities
  for (int i=0; i<N; ++i) {
    pos_x[i]+=vel_x[i]*delta_t;
    pos_y[i]+=vel_y[i]*delta_t;
    if(abs(vel_x[i])<0.0001) vel_x[i]=0;
    if(abs(vel_y[i])<0.0001) vel_y[i]=0;
    if (pos_x[i]<left_x) {
      pos_x[i]=left_x+1;
      vel_x[i]=-1*e*vel_x[i];
    }
    if (pos_x[i]>right_x) {
      pos_x[i]=right_x-1;
      vel_x[i]=-1*e*vel_x[i];
    }
    if (pos_y[i]<up_y) {
      pos_y[i]=up_y+1;
      vel_y[i]=-1*e*vel_y[i];
    }
    if (pos_y[i]>floor_y) {
      pos_y[i]=floor_y-1;
      vel_y[i]=-1*e*vel_y[i];
    }
  }
  // draw all balls
  for (int i=0; i<N; ++i) {
    ellipse(pos_x[i], pos_y[i], 10, 10);
  }
  if (click) {
    // update velocities - apply impulse
    for (int i=0; i<N; ++i) {
      float d=dist(click_x, click_y, pos_x[i], pos_y[i]);
      if(d==0) d=1;
      float theta=atan2(click_y-pos_y[i],pos_x[i]-click_x);
      vel_x[i]+=J*cos(theta)*25/d;
      vel_y[i]-=J*sin(theta)*25/d;
    }
  } else {
    // update velocities - apply gravity
    for (int i=0; i<N; ++i) {
      vel_y[i]=vel_y[i]+g*delta_t;
    }
  }

  click=false;
}

void mousePressed() {
  if (mouseX<right_x && mouseX>left_x && mouseY<360 && mouseY>0) {
    click=true;
    click_x=mouseX; 
    click_y=mouseY;
    stroke(255,0,0); fill(0,0,0);
    ellipse(mouseX,mouseY,50,50);
    stroke(255,255,255); fill(255,255,255);
  }
}