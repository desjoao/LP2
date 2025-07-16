package br.uerj.ime.lp2;

import com.excp.*;

public class Calc
{
	
	public Calc()
	{
	}
	
	public void TestaArgs(String[] args) throws NumArgsEx
	{
	      
		if (args.length != 3)
		  throw new NumArgsEx("Numero de argumentos incorreto.");
	}

	public int soma (String num1, String num2) throws NumArgsEx, NaoNumEx
	{
	    int valor1=0, valor2 =0;
           
	   	
	    try
	    {
	    	
		  valor1 = Integer.parseInt(num1);
		  valor2 = Integer.parseInt(num2);
				
	    }
	    catch(Exception e)
	    {
		  throw new NaoNumEx("Letra passada como argumento: Nao eh possivel converter.");
	    }
	    	
			
	    return valor1 + valor2;
	}

	public double div (String num1, String num2) throws NumArgsEx, NaoNumEx, Div0ex
	{
	    double valor1=0, valor2=0,resultado=0;

	   
	    try
	    {
		  valor1 = Double.parseDouble(num1);
		  valor2 = Double.parseDouble(num2);
	    }
	    catch(Exception e)
	    {
		  throw new NaoNumEx("Letra passada como argumento: Nao eh possivel converter.");
	    }
		 
	    if (valor2 == 0)
		throw new Div0ex("Nao eh possivel fazer divisao por zero.");
	    else
		resultado = valor1/valor2;	
	    
	  
			
	    return  resultado;
	}
}
