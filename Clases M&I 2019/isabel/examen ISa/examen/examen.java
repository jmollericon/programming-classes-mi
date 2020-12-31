// MODULO4 : OBTENER LA NOMBRE COMPLETO DEL MEJOR ALUMNOS DE LA CARRERA X
void obtenerMejorAlumnoCarreraX(){
    int sw = -1, idCarrera = 0;
    do{
        idCarrera = Integer.parseInt(JOptionPane.showInputDialog("ingrese el id de la carrera x: "));
        sw = verificarCarrera(idCarrera);
    }while(sw < 0);
    int idAlu = idMejorAlumnoCarrera(idCarrera);
    mostrarCedulaNombreCompleto(idAlu);
}
int verificarCarrera(int idCarrera) {
    File f1 = new File("carrera.dat");     // archivo con datos de las materias
    // flag + idCar + nomCar
    //   1  +   4   +   40+2   = 47 bytes
    int posEnc = -1;
    try {
        RandomAccessFile raf = new RandomAccessFile(f1, "r");
        int pos = 0;
        while(pos < raf.length()) {
            raf.seek(pos);
            boolean flag    = raf.readBoolean();
            int idCar       = raf.readInt();
            String nomMat   = raf.readUTF();
            if(idCar == idCarrera) { // cunado se encuentra la materia
                posEnc = pos;
                break;
            }
            pos = pos + 47;
        }
    }catch(Exception e) {
        JOptionPane.showMessageDialog(null, "error "+e.getMessage());
    }
    return posEnc;
}
int idMejorAlumnoCarrera(int idCarrera) {
    int maximaNota = 0;
    int idAlumno = -1;
    File f2 = new File("materia.dat");     // archivo con datos de las materias
    // flag + idMateria + nomMateria + idCar
    //   1  +     4    +    30+2     +   4   = 41 bytes
    try {
        RandomAccessFile raf = new RandomAccessFile(f2, "r");
        int pos = 0;
        while(pos < raf.length()) {
            raf.seek(pos);
            boolean flag    = raf.readBoolean();
            int idMat       = raf.readInt();
            String nomMat   = raf.readUTF();
            int idCar       = raf.readInt();
            if(idCar==idCarrera && flag==true) { // cunado se encuentra la caarrera
                idAlumno = idAlu_MaximaNotaCarrera(idMat, idAlumno, maximaNota);
            }
            pos = pos + 41;
        }
    }catch(Exception e) {
        JOptionPane.showMessageDialog(null, "error "+e.getMessage());
    }
    return idAlu;
}
int idAlu_MaximaNotaCarrera(int idMateria, int idAlumno, int maximaNota) {
    File f4 = new File("inscripcion.dat");     // archivo con datos de la inscripcion
    // gestion + idAlu + idMat + nota
    //   6+2   +   4   +   4   +  4   = 20 bytes
    try {
        RandomAccessFile raf = new RandomAccessFile(f4, "r");
        int pos = 0;
        while(pos < raf.length()) {
            raf.seek(pos);
            String gestion  = raf.readUTF();
            int idAlu       = raf.readInt();
            int idMat       = raf.readInt();
            int nota        = raf.readInt();
            if((maximaNota < nota) && (idMat == idMateria)) {
                maximaNota = nota;
                idAlumno = idAlu;
            }
            pos = pos + 18;
        }
    }catch(Exception e) {
        JOptionPane.showMessageDialog(null, "error "+e.getMessage());
    }
    return idAlumno;
}
void mostrarCedulaNombreCompleto(int idAlumno) {
    File f3 = new File("alumno.dat");     // archivo con datos de los alumnos
    // flag + idAlu + cedula +  pat  +  mat  +  noms  + fechaNac 
    //   1  +   4   +   8    + 20+2  + 20+2  +  25+2  +  10+2      = 96 bytes
    int maximaNota = 0;
    try {
        RandomAccessFile raf = new RandomAccessFile(f3, "r");
        int pos = 0;
        while(pos < raf.length()) {
            raf.seek(pos);
            boolean flag    = raf.readBoolean();
            int idAlu       = raf.readInt();
            long cedula     = raf.readInt();
            String pat      = raf.readUTF();
            String mat      = raf.readUTF();
            String noms     = raf.readUTF();
            String fechaNac = raf.readUTF();
            if(idAlumno == idAlu) {
                JOptionPane.showMessageDialog(null, "El mejor Alumno es:\nCI: "+cedula+"\nNombre: "+pat+" "+mat+" "+noms);
                break;
            }
            pos = pos + 96;
        }
    }catch(Exception e) {
        JOptionPane.showMessageDialog(null, "error "+e.getMessage());
    }
}
