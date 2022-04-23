package co.edu.upbmovil.android.datos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import co.edu.upbmovil.android.modelo.Estudiante;

public class EstudianteCAD {

    public static boolean guardarEstudiante(Estudiante e, Context c){
        // llamando a la base de datos en modo escritura
        Datos dbHelper=new Datos(c);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // configurar los valores a guardar
        ContentValues values = new ContentValues();
        values.put(Datos.EST_APELLIDO, e.getApellido());
        values.put(Datos.EST_NOMBRE, e.getNombre());
        values.put(Datos.EST_CORREO, e.getCorreo());
        values.put(Datos.EST_EDAD, e.getEdad());
        values.put(Datos.EST_DIRECCION, e.getDireccion());
        values.put(Datos.EST_TELEFONO, e.getTelefono());

        long id = db.insert(Datos.TABLA_ESTUDIANTES, null, values);
        return (id>0);
    }
}
