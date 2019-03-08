import game.Vector2D;

public class Rectangle {
    Vector2D position; // vị trí góc trên bên trái hình chữ nhật ()
    int width; // chiều rộng hcn
    int height; // chiều cao hcn

    public Rectangle(int x, int y, int width, int height) {
        this(new Vector2D(x, y), width, height);
    }

    public Rectangle(Vector2D position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public double top() {
        return this.position.y;
    }

    public double bot() {
        return (this.position.y + height);
    }

    public double right() {
        return (this.position.x + height);
    }

    public double left() {
        return this.position.x;
    }



    /**
     * @param other
     * @return false: nếu 2 hcn khong giao nhau
     */

    public boolean intersects(Rectangle other) {
        // TODO: 1. Triển khai phần code kiểm tra va chạm giữa 2 () ở đây
        return other.right() > this.left()
                && other.left() < this.right()
                && other.bot() > this.top()
                && other.top() < this.bot();
    }

        public static void main (String[]args){
            // TODO: 2. Chạy hàm main này để test kết quả hàm intersects đã triển khai
            Rectangle rect1 = new Rectangle(0, 0, 100, 100);
            Rectangle rect2 = new Rectangle(50, 50, 100, 100);
            Rectangle rect3 = new Rectangle(200, 200, 100, 100);
            System.out.println(rect1.intersects(rect2) + " " + true);
            System.out.println(rect1.intersects(rect3) + " " + false);
        }
    }

