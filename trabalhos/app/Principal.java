package app;

import br.uerj.ime.lp2.*;
import com.excp.*;

class Principal
{
	public static void main (String[] args) 
	{
		String nome1,nome2;
		Calc objeto = new Calc();
		int soma;
		double div;	
	
	       try
	       {
	       		objeto.TestaArgs(args);
			if (args[0].equals("soma"))
			{
			   nome1 = args[1];
			   nome2 = args[2];
			   soma = objeto.soma(nome1,nome2);
			   System.out.println("Soma = " + soma);
			}
			else if (args[0].equals("div"))
			{
			   nome1 = args[1];
			   nome2 = args[2];
			   div = objeto.div(nome1,nome2);
			   System.out.println("Divisao = " + div);
			}
			else
			System.out.println("Operacao matematica invalida.");
	      } 
	      
	      catch(NumArgsEx e)  
	       {
	    		System.out.println(e.getMessage());
	       }  
	      catch(NaoNumEx e)
	       {
		   	System.out.println(e.getMessage());
	       }
	      catch(Div0ex e)
	       {	
	          	System.out.println(e.getMessage());
	       }
	    
	       
	}
}
