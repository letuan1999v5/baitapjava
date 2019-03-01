package Game1;

import java.sql.SQLOutput;

public class Vector2D {
    public double x;
    public double y;
    //ham tao rong
    public Vector2D(){
        this.x=0;
        this.y=0;
    }
    public Vector2D(double x, double y){
        this.x=x;
        this.y=y;
    }
    //TODO: continue upgrading...

    public Vector2D clone(){
        return new Vector2D(this.x,this.y);
    }
    //gan cap x y moi cho vector duoc goi
    public void set(double x, double y){
        this.x=x;
        this.y=y;
    }
    //cộng giá trị x, y vào vector được gọi
    public void add(double x, double y){
        this.x+=x;
        this.y+=y;
    }
    //trừ giá trị x, y vào vector được gọi
    public void minus(double x, double y){
        this.x-=x;
        this.y-=y;
    }
    //nhân giá trị rate vào vector được gọi
    public void scale(double rate){
        this.x=this.x*rate;
        this.y=this.y*rate;
    }
    //trả ra độ dài của vector được gọi
    public double getLength(){
        return Math.sqrt(this.x*this.x+this.y*this.y);
    }
    //giữ nguyên hướng của vector được gọi, thay đổi độ dài bằng
    //độ dài truyền vào
    public void setLength(double length){
        double currentLength = this.getLength();
        if(currentLength!=0){
            this.x = this.x*length/currentLength;
            this.y = this.y*length/currentLength;
        }
    }
    //trả ra góc tạo giữa vector với trục hoành
    public double getAngle(){
        return Math.atan(this.y/this.x);
    }
    //giữ nguyên độ dài của vector, quay vector đến góc truyền vào
    public void setAngle(double angle){
        double length = this.getLength();
        this.x = length*Math.cos(angle);
        this.y = length*Math.sin(angle);
    }
}
