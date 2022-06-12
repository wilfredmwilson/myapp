package com.example.appproject;

public class Variables_Globales {
    private  static Variables_Globales instance;

    //AQUI DECLARAREMOS NUESTRAS VARIABLES GLOBALES PARA ALMACENDAR LOS DATOS DE LA FUNCION DE INSIO DE SESION Y LUEGO MOSTRARLOS EN EL
    //ACTIVITY MENU

    private  static  int _login_id=0;
    private  static  String _usertype="";
    private  static  String _status="";

    public  int get_login_id() {
        return _login_id;
    }

    public  void _login_id(int _login_id) {
        Variables_Globales._login_id = _login_id;
    }

    public  String usertype() {
        return _usertype;
    }

    public  void set_usertype(String _usertype) {
        Variables_Globales._usertype = _usertype;
    }

    public  String status() {
        return _status;
    }

    public  void set_status(String _status) {
        Variables_Globales._status = _status;
    }


    public static synchronized Variables_Globales getInstance() {
        if (instance == null) {
            instance = new Variables_Globales();
        }
        return instance;
    }
}