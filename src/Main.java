
public class Main {

    public static void main(String[] args) {
        try {
            Input("asdd11","1234","123");
        }
        catch (WrongLoginException e){
            System.out.println("Неправильный логин");
        }
        catch (WrongPasswordException e){
            System.out.println("Неправильный пароль или пароли не совпадают");
        }
    }
    public static void Input(String login,String password,String confirmPassword) throws WrongLoginException,WrongPasswordException{
        String line = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_";
        char[] array = line.toCharArray();
        char[] logi = login.toCharArray();
        char[] passwo = password.toCharArray();
        int c = 0;
        for (int i = 0 ;i <= array.length-1;i++){
            for (int j = 0;j <= logi.length-1;j++){
                if (logi[j] == array[i]){
                    c ++;
                    break;
                }
                else if (c == logi.length || logi.length >20){

                    throw new WrongLoginException();
                }
            }
            c = 0;
            for (int j = 0;j <= passwo.length-1;j++){
                if (passwo[j] == array[i]){
                    c++;
                    break;
                }
                else if (c == passwo.length || passwo.length >20){
                    throw new WrongPasswordException();
                }
            }

        }
        if (password.equals(confirmPassword) == false){
            throw new WrongPasswordException();
        }


    }
}