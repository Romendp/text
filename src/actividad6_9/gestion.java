package actividad6_9;

import java.util.*;
import java.io.*;


public class gestion {
    
    public void Menu(){
        System.out.println("1.- introduce texto");
        System.out.println("2.- mostrar primeras filas");
        System.out.println("3.- mostrar ultimas filas");
        System.out.println("4.- cuenta lineas/caracteres/palabras");
        System.out.println("5.- visualiza fichero");
        System.out.println("6.- visualizar lineas impares");
        System.out.println("7.- copiar fichero en mayusculas");
        System.out.println("8.- añadir fichero a otro");
        System.out.println("9.- invertir lineas");
        System.out.println("10.- traducir java a pseudocodigo");
        System.out.println("0.- Salir");
    }
    
    public void gestionMenu(){
        Scanner leer = new Scanner(System.in);
        int opcion;
               
        do{
            Menu();
            System.out.println("Elija opción");
            opcion = leer.nextInt();
            
            switch(opcion){
                case 1:
                    introduceTexto();
                    break;                  
                case 2:
                    mostrarNprimeras();
                    break;
                case 3:
                    mostrarNultimas();
                    break;
                case 4:
                    contador();
                    break;      
                case 5:
                    visualizar();
                    break;
                case 6:
                    visualizarImpares();
                    break;
                case 7:
                    copiarEnMayusculas();
                    break;
                case 8:
                    unoDentroDeOtro();
                    break;
                case 9:
                    invertirTexto();
                    break;
                case 10:
                    traductor();
                    break;
            }
        }while(opcion != 0);
    }
    
    public void introduceTexto(){
        
        File ar = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        String texto="";
        Scanner leer = new Scanner(System.in);        
        
        do{
            try {   
                ar = new File("c:\\texto.txt");
                fw = new FileWriter(ar,true);                
                bw = new BufferedWriter(fw);
                           
                System.out.print("Escriba la frase que quiere introducir al fichero");
                texto = leer.nextLine();
                bw.write(texto);
                bw.newLine();  
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
            finally{
                if (bw != null){
                        try {
                            bw.close();
                            fw.close();
                        } catch (IOException ex) 
                        {
                            System.out.println("es asi");
                            //Logger.getLogger(gestion.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }       
                }       
        }while(texto.equals("fin") == false);
    }//fin introduceTexto   
    
    public void mostrarNultimas(){        

    File ar = null;
    FileReader fr = null;
    BufferedReader br = null;
    String linea;
    int numeroLineas;
    
    Scanner leer = new Scanner(System.in);
    
        try{
            ar = new File("c:\\texto.txt");
            fr = new FileReader(ar);
            br = new BufferedReader(fr);
            int contador = 0, contador2 = 0;
            
            System.out.println("introduce número de lineas a mostrar");
            numeroLineas = leer.nextInt();
            
            while (((linea=br.readLine()) != null)){
                contador++;
            }
            int paso = contador - numeroLineas;
            fr = new FileReader(ar);
            br = new BufferedReader(fr);
            
            while ((linea=br.readLine()) != null ){
                if(contador2 >= paso && contador2 <= contador){
                    System.out.println(linea);
                    contador2++;
                }
                else
                    contador2++;
            }    
        }catch(IOException e){
                System.out.println("todo va mal");
        }
        finally{
            try{
                if (null != br){
                    fr.close();
                    br.close();
                }
            }catch(Exception e2){
                System.out.println("pero aun");
            }
        }
    }        
    
    public void mostrarNprimeras(){
        
    File ar = null;
    FileReader fr = null;
    BufferedReader br = null;
    String linea;
    int numeroLineas;
    Scanner leer = new Scanner(System.in);
    
        try{
            ar = new File("c:\\texto.txt");
            fr = new FileReader(ar);
            br = new BufferedReader(fr);
            int contador = 0;
            
            System.out.println("introduce número de lineas a mostrar");
            numeroLineas = leer.nextInt();
            
            while (((linea=br.readLine()) != null) && contador < numeroLineas ){
                System.out.println(linea);
                contador++;
            }
        }catch(IOException e){
                System.out.println("todo va mal");
        }
        finally{
            try{
                if (null != br){
                    fr.close();
                    br.close();
                }
            }catch(Exception e2){
                System.out.println("pero aun");
            }
        }
    }
       
    public void contador(){
        
    File ar = null;
    FileReader fr = null;
    BufferedReader br = null;
    String linea;
    int letra;
    Scanner leer = new Scanner(System.in);
    
        try{
            ar = new File("c:\\texto.txt");
            fr = new FileReader(ar);
            br = new BufferedReader(fr);
            int contador = 0;
            int contador2 = 0, cont2 = 0;
            int contador1 = 0, cont1 = 0;
            int contador3 = 0, cont3 = 0, contadorLinea = 0;
            int paso = -1;
            StringTokenizer palabras;
            int npalabras;
            
            
            
            //cuenta los caracteres          
            
            while (((linea = br.readLine()) != null)){
                contador += linea.length();
            }
            
            /*-------------------------------------------------*/
            fr = new FileReader(ar);
            br = new BufferedReader(fr);
            
            //cuenta las lineas del texto
            while (((linea=br.readLine()) != null) ){
                
                contador2++;
            }
            
            //----------------------------------------------
            
            //cuenta las palabras
            fr = new FileReader(ar);
            br = new BufferedReader(fr);

                while (((letra=br.read()) != -1)){ 
                    if (letra == ' ')
                    {
                        cont1++;
                        paso = 0;                   
                    }
                    else if (letra != ' ' && paso == 0)
                    {
                        contador3++;
                        paso = 1;
                    }
                    else if (letra != ' ' && paso == -1)
                    {
                        contador3++;
                        paso = 1;
                    }
                    else if(letra == '\n')
                    {
                        paso = -1;
                    }
                }
                
                System.out.println("tiene "+contador2 +" lineas," +contador3 
                    +" palabras y "+(contador - cont1) +" letras");
                       
            
        }catch(IOException e){
                System.out.println("todo va mal");
        }
        finally{
            try{
                if (null != br){
                    fr.close();
                    br.close();
                }
            }catch(Exception e2){
                System.out.println("pero aun");
            }
        }
    }
    
    public void visualizar(){
        
    File ar = null;
    FileReader fr = null;
    BufferedReader br = null;
    String linea;
    int contador = 1;
    Scanner leer = new Scanner(System.in);
    
        try{
            ar = new File("c:\\texto.txt");
            fr = new FileReader(ar);
            br = new BufferedReader(fr);
            
            while (((linea=br.readLine()) != null)){              
                    System.out.println(linea);
                    leer.next();
            }
        }catch(IOException e){
                System.out.println("todo va mal");
        }
        finally{
            try{
                if (null != br){
                    fr.close();
                    br.close();
                }
            }catch(Exception e2){
                System.out.println("pero aun");
            }
        }
    }
    
    public void visualizarImpares(){
        
    File ar = null;
    FileReader fr = null;
    BufferedReader br = null;
    String linea;
    int contador = 1;
    Scanner leer = new Scanner(System.in);
    
        try{
            ar = new File("c:\\texto.txt");
            fr = new FileReader(ar);
            br = new BufferedReader(fr);
            
            while (((linea=br.readLine()) != null)){
                if (impar(contador) == false){
                    System.out.println(linea);
                    contador++;
                }
                else
                    contador++;
            }
        }catch(IOException e){
                System.out.println("todo va mal");
        }
        finally{
            try{
                if (null != br){
                    fr.close();
                    br.close();
                }
            }catch(Exception e2){
                System.out.println("pero aun");
            }
        }
    }
    
    public void copiarEnMayusculas()
    {
        File ar = null;
        File ar1 = null;
        FileReader fr = null;
        FileWriter fw = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        String palabra = "";
        String palabra1 = "";
        
        try{
            ar = new File("c:\\texto.txt");
            ar1 = new File("c:\\texto1.txt");           
            fr = new FileReader(ar);
            fw = new FileWriter(ar1);
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);
            
            while((palabra = br.readLine()) != null){
                
                palabra1 = palabra.toUpperCase();
                bw.write(palabra1);
                bw.newLine();
            }           
        }
        catch(IOException e){
                    
        }
        finally{
                if (bw != null){
                        try {
                            bw.close();
                            fw.close();
                        } catch (IOException ex) 
                        {
                            System.out.println("es asi");
                            //Logger.getLogger(gestion.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }       
                } 
    }
    
    /**
     * lo que tenemos que hacer es leer el texto, y al escribir el otro 
     *      empezamos a hacerlos por la última fila, y la siguiente vuelta, la
     *      penúntila.. igual que hicimos al mostrar las n últimas.
     */
    public void invertirTexto(){
        
    File ar = null;
    FileReader fr = null;
    BufferedReader br = null;
    String linea;
    int numeroLineas;
    
    Scanner leer = new Scanner(System.in);
    
        try{
            ar = new File("c:\\texto.txt");
            fr = new FileReader(ar);
            br = new BufferedReader(fr);
            int contador = 0, contador2 = 0;
                    
            
            while (((linea=br.readLine()) != null)){
                contador++;
            }

            fr = new FileReader(ar);
            br = new BufferedReader(fr);
            
            while (contador >= 0){
                while ((linea=br.readLine()) != null ){
                    if(contador2 == contador){
                        System.out.println(linea);
                    }
                    contador2++;
                }
                contador--;
                contador2=0;
                fr = new FileReader(ar);
                br = new BufferedReader(fr);
            }
        }
        catch(IOException e)
        {
                System.out.println("todo va mal");
        }
        finally{
            try{
                if (null != br){
                    fr.close();
                    br.close();
                }
            }catch(Exception e2){
                System.out.println("pero aun");
            }
        }  
        
    }
    
    
    public void unoDentroDeOtro(){
        File ar = null;
        File ar1 = null;
        FileReader fr = null;
        FileWriter fw = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        String palabra = "";
        String palabra1 = "";
        
        try{   
            ar = new File("c:\\texto.txt");
            ar1 = new File("c:\\texto1.txt");
            fw = new FileWriter(ar1,true);
            bw = new BufferedWriter(fw);
            fr = new FileReader(ar);           
            br = new BufferedReader(fr);
            
            
            while((palabra = br.readLine()) != null){  
                bw.write(palabra);
                bw.newLine();
            }  
        }
        catch(IOException e){
                    
        }
        finally{
                if (bw != null){
                        try {
                            bw.close();
                            fw.close();
                        } catch (IOException ex) {
                            System.out.println("es asi");
                            //Logger.getLogger(gestion.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }       
                } 
    }
    
    public boolean impar (int numero){
        
        boolean resultado = false;
        
        if (numero%2 == 0 )
            resultado = true;
        
        return resultado;
    }
    
    
    public void traductor(){
       
        File ar = null;
        File ar1 = null;
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        String linea;
        Scanner leer = new Scanner(System.in);
        
        
        try{
            ar = new File("c:\\texto.txt");
            fr = new FileReader(ar);
            br = new BufferedReader(fr);
            ar1 = new File("c:\\texto1.txt");
            fw = new FileWriter(ar1);
            bw = new BufferedWriter(fw);
            
            while((linea=br.readLine()) != null){
                if(linea.equals("{")){
                    bw.write("INICIO");
                }
                else if(linea.equals("}")){
                    bw.write("FIN");
                }
                else if(linea.equals("WHILE")){
                    bw.write("MIENTRAS");
                }
                else if(linea.equals("FOR")){
                    bw.write("PARA");
                }
                else if(linea.equals("SYSTEM.OUT.PRINTLN")){
                    bw.write("MOSTRAR");
                }
                else if(linea.equals("NEXT")){
                    bw.write("LEE");
                }
                else
                    bw.write(linea);
                bw.newLine();
            }
            
        }
        catch(IOException e)
        {
            
        }
        finally{
                if (bw != null){
                        try {
                            bw.close();
                            fw.close();
                        } catch (IOException ex) 
                        {
                            System.out.println("es asi");
                            //Logger.getLogger(gestion.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }       
                }
        
    }
    
    
    
    public void reiniciarReaderrBuffers(File ar) throws IOException{
        
        FileReader fr = null;
        BufferedReader br = null;
        
       
            fr = new FileReader(ar);
            br = new BufferedReader(fr);
       
        
        
    }
    
    /**
     * Estas dos clases fueron creadas para agregar un diccionario de palabras
     * que pueden ser sustituidas por su correspondiente traducción
     */
    private class diccionario
    {
        ArrayList <palabras> diccionario;

        public diccionario() {
            
            diccionario = new ArrayList <palabras>();
        }

        public ArrayList<palabras> getDiccionario() {
            return diccionario;
        }

        public void setDiccionario(ArrayList<palabras> diccionario) {
            this.diccionario = diccionario;
        }
        
        
        
        
    }
    
    private class palabras
    {
        String original;
        String traduccion;

        public palabras(String original, String traduccion) {
            this.original = original;
            this.traduccion = traduccion;
        }
        
        public palabras(){
            this.original = " ";
            this.traduccion = " ";
        }

        public String getOriginal() {
            return original;
        }

        public void setOriginal(String original) {
            this.original = original;
        }

        public String getTraduccion() {
            return traduccion;
        }

        public void setTraduccion(String traduccion) {
            this.traduccion = traduccion;
        }
        
        
    }
    
}//fin clase gestion   

