package energiaEcuador;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		int[] consumoCcsUio = {400, 432, 400, 420, 432, 460, 432, 400, 432, 300, 213};
		int[] consumoCcsGye = {120, 55, 32, 120, 75, 32, 150, 55, 32, 120, 97,32};
		
		int[] consumoSoplGye = {310, 220, 321, 310, 220, 321, 310, 220, 321, 310, 220,321};
		int[] consumoSoplUio = {400, 432, 587, 400, 432, 587, 400, 432, 587, 400, 432,587};
		int[] consumoSoplLoja = {50, 32, 32, 50, 32, 32, 50, 32, 32, 50, 32,32};
		
		Datos conjunto1Ccs = new Datos(consumoCcsUio);
		Datos conjunto2Ccs = new Datos(consumoCcsGye);
		
		Datos conjunto1Sopl = new Datos(consumoSoplGye);
		Datos conjunto2Sopl = new Datos(consumoSoplUio);
		Datos conjunto3Sopl = new Datos(consumoSoplLoja);
		
		Hashtable<String, Datos> Ccs = new Hashtable<String, Datos>();
		Ccs.put("Quito",conjunto1Ccs );
		Ccs.put("Guayaquil", conjunto2Ccs);
		
		Hashtable<String, Datos> Sopladora = new Hashtable<String, Datos>();
		Sopladora.put("Guayaquil", conjunto1Sopl);
		Sopladora.put("Quito", conjunto2Sopl);
		Sopladora.put("Loja", conjunto3Sopl);
		
		Scanner sc = new Scanner (System.in);
		int op = -1;
		String nombreCiudad, nombrePlanta, nombreRegion;
		int resultTotal = 0;
		int resultCcs = 0, resultSopl = 0;
		
		while(op!=0) {
			System.out.println("---------------MATRIZ ENERGÉTICA DEL ECUADOR---------------");
			System.out.println("<1>Mostrar total de megavatios por ciudad en una planta de energía");
			System.out.println("<2>Mostrar total de megavatios de una ciudad por planta de energía");
			System.out.println("<3>Dinero recaudado por región");
			System.out.println("<0>Salir");
			System.out.println("Ingrese una opción: ");
			op = sc.nextInt();
			System.out.println();
			
			switch(op) {
				case 0:
					System.out.println("Programa finalizado...");
					System.out.println();
					break;
				case 1:
					System.out.print("Ingrese planta de energía: ");
					nombrePlanta= sc.next();
					
					if(nombrePlanta.toLowerCase().equals("sopladora")) {
						System.out.print("Ingrese ciudad: ");
						nombreCiudad = sc.next();
						if(Sopladora.containsKey(nombreCiudad)) 
							System.out.println("El total de megavatios de "+nombreCiudad+" en la planta de energía "+nombrePlanta+" es de: "+(Sopladora.get(nombreCiudad)).calculo_megavatios());
						else 
							System.out.println("Ciudad no registrada en la planta de energía");
						
					}
					else if (nombrePlanta.toLowerCase().equals("coca codo sinclair")) {
						System.out.print("Ingrese nombre de la ciudad: ");
						nombreCiudad = sc.next();
						if(Ccs.containsKey(nombreCiudad) ) 
							System.out.println("El total de megavatios de "+nombreCiudad+" en la planta de energía "+nombrePlanta+" es de: "+(Ccs.get(nombreCiudad)).calculo_megavatios());
						else 
							System.out.println("Ciudad no registrada en la planta de energía");	
					}
					else 
						System.out.println("ERROR!!");
					System.out.println();
					break;
				case 2:
					System.out.print("Ingrese ciudad: ");
					nombreCiudad = sc.next();
					boolean x = Sopladora.containsKey(nombreCiudad), j = Ccs.containsKey(nombreCiudad);
						
					if(x == true&& j == true ){
						resultCcs = (Sopladora.get(nombreCiudad)).calculo_megavatios(); 
						resultSopl = (Ccs.get(nombreCiudad)).calculo_megavatios();
						System.out.println(nombreCiudad+" es abastecida por ambas plantas.-"+"\n"+"Coca Codo Sinclair con " +resultCcs +" voltios"+"\n"+"Sopladora con "+ resultSopl+" voltios");
					}
					else if(x == false && j == true) {
						resultCcs=(Ccs.get(nombreCiudad)).calculo_megavatios(); 
						System.out.println(nombreCiudad+" es abastecida por Coca Codo Sinclair con "+ resultSopl+" voltios");
					}
					else if(x == true && j == false) {
						resultSopl=(Sopladora.get(nombreCiudad)).calculo_megavatios(); 
						System.out.println(nombreCiudad+" es abastecida por Sopladora con "+ resultSopl+" voltios");
					}
					System.out.println();
					break;
				case 3:
					System.out.print("Ingrese región : ");
					nombreRegion=sc.next();
					int numero=0 ,i;
					
					if(nombreRegion.toLowerCase().equals("sierra")) {
						for(i=0; i<consumoCcsUio.length; i++) {
							numero=consumoCcsUio[i]+numero;	
						}
						int resul=numero*75;
						    
						for(i=0; i<consumoSoplUio.length;i++) {
							numero=consumoSoplUio[i]+numero; 
						}
						int resul1=numero*79;
						for(i=0; i<consumoSoplLoja.length; i++) {
							numero=consumoSoplLoja[i]+numero;
						}
						int resul2 = numero*32;
						resultTotal = resul1+resul2+resul; 
						System.out.println("El dinero recaudado en la región Sierra es: $"+resultTotal);
						
					 }else if(nombreRegion.toLowerCase().equals("costa")) {
						 for(i=0; i<consumoCcsGye.length; i++) {
							numero = consumoCcsGye[i]+numero;
						 }
						 int resul=numero*64;  
						 for(i=0; i<consumoSoplGye.length;i++) {
							numero = consumoSoplGye[i]+numero;
						 }
						 int resul1 = numero*85;
						 resultTotal = resul1+resul;
						 System.out.println("El dinero recaudado en la región Costa es: $"+resultTotal);
						 
					  }else {
						  System.out.println("ERROR!!");						  
					  }
					System.out.println();
					break;
			}
		}
		sc.close();
	}
}
