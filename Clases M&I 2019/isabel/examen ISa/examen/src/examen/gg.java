package examen;

import java.io.File;
import java.io.RandomAccessFile;

import javax.swing.JOptionPane;

public class gg {

	// MODULO3 : OBTENER LA NOTA PROMEDIO DE DE APROBADOS DE LA MATERIA X
	void obtenerMejorAlumnoMateriaX(){
	    int sw = -1;
	    do{
	        int idMateria = Integer.parseInt(JOptionPane.showInputDialog("ingrese el id de la materia x: "));
	        sw = verificarMateria(idMateria);
	    }while(sw < 0);
	    double promedio = obtenerPromedioAprobadosMateriaX(idMateria);
	    JOptionPane.showMessageDialog(null, "La nota promedio de los aprobados es: "+promedio+" pts. ");
	}
	int verificarMateria(int idMateria) {
	    File f2 = new File("materia.dat");     // archivo con datos de las materias
	    // flag + idMateria + nomMateria + idCar
	    //   1  +     4    +    30+2     +   4   = 41 bytes
	    int posEnc = -1;
	    try {
	        RandomAccessFile raf = new RandomAccessFile(f2, "r");
	        int pos = 0;
	        while(pos < raf.length()) {
	            raf.seek(pos);
	            boolean flag    = raf.readBoolean();
	            int idMat       = raf.readInt();
	            String nomMat   = raf.readUTF();
	            int idCar       = raf.readInt();
	            if(idMat == idMateria) { // cunado se encuentra la materia
	                posEnc = pos;
	                break;
	            }
	            pos = pos + 41;
	        }
	    }catch(Exception e) {
	        JOptionPane.showMessageDialog(null, "error "+e.getMessage());
	    }
	    return posEnc;
	}
	double obtenerPromedioAprobadosMateriaX(int idMateria) {
	    File f4 = new File("inscripcion.dat");     // archivo con datos de la inscripcion
	    // gestion + idAlu + idMat + nota
	    //   6+2   +   4   +   4   +  4   = 20 bytes
	    int c = 0; 
	    double prom = 0.0;
	    try {
	        RandomAccessFile raf = new RandomAccessFile(f4, "r");
	        int pos = 0;
	        while(pos < raf.length()) {
	            raf.seek(pos);
	            String gestion  = raf.readUTF();
	            int idAlu       = raf.readInt();
	            int idMat       = raf.readInt();
	            int nota        = raf.readInt();
	            if((nota >= 51) && (idMat == idMateria)) {
	                prom = prom + nota;
	                c++;
	            }
	            pos = pos + 18;
	        }
	        prom = prom/c;
	    }catch(Exception e) {
	        JOptionPane.showMessageDialog(null, "error "+e.getMessage());
	    }
	    return prom;
	}


}
