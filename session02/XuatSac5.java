interface UserActions {
    default void logActivity(String activity) {
        System.out.println(activity);
    }
}

interface AdminActions {
    default void logActivity(String activity) {
        System.out.println(activity);
    }
}

class SuperAdmin implements UserActions, AdminActions {

    @Override
    public void logActivity(String activity) {
        // TODO Auto-generated method stub
        UserActions.super.logActivity(activity);
    }

    // Nếu cùng thực thi cả 2 interface thì Java không hiểu phải thực thi phương
    // thức của interface nào giải pháp là phải ghi đè lại phương thức

}

public class XuatSac5 {
    public static void main(String[] args) {

    }
}
