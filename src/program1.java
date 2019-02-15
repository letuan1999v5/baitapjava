public class program1 {
    public static double[] equation2(double a, double b, double c) {
        double[] result = new double[2];
        double x = Math.sqrt(b * b - 4 * a * c);
        if (a == 0 && b != 0) {
            result[0] = result[1] = -b / c;
            return result;
        } else if (a != 0) {
            if (b * b - 4 * a * c >= 0) {
                result[0] = (-b - x) / (2 * a);
                result[1] = (-b + x) / (2 * a);
                return result;
            } else {
                result = null;
                return result;
            }
        }
        return result;
    }

    /*public static void main(String[] args){
        double[] result = equation2(1,2,3);
        if(result==null){
            System.out.println("No solution");
        }
        else if(result[0]==result[1]){
            System.out.println("x="+result[0]);
        }
        else{
            System.out.println("x1="+result[0]);
            System.out.println("x2="+result[1]);
        }

    }*/
    public static void main(String[] args) {
        human human1 = new human();
        System.out.println(human1.name);
        human1.sleep(3);
        human human2 = new human();
        System.out.println(human2.name);
        human2.eat();

    }
}
