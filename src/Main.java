/**
 * Autor kodu: Sewery Adamczyk
 * Pochodzenie: http://pl.spoj.com/problems/AL_23_02/
 */

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] tab1 = new int[1000000];
		int[] tab2 = new int[1000000];
		int t = readInt(br);
		//System.out.println(t);
		
		for(int i=0; i<t; i++)
		{		
			int pozycja1=0;
			int pozycja2=0;
			int znak = br.read();
			while (znak<'a' || 'z'<znak)
			{
				znak = br.read();
			}
			while (znak>='a' && 'z'>=znak)
			{
				tab1[pozycja1] = znak;
				pozycja1++;
				znak = br.read();
			}
			while (znak<'a' || 'z'<znak)
			{
				znak = br.read();
			}

			while (znak>='a' && 'z'>=znak)
			{
				tab2[pozycja2] = znak;
				pozycja2++;
				znak = br.read();
			}
			
			int[] wieksze;
			int[] mniejsze;
			int max;
			int min;
			if(pozycja1 > pozycja2)
			{
				wieksze = tab2;
				max = pozycja2;
				mniejsze = tab1;
				min = pozycja1;
			}
			else
			{
				wieksze = tab1;
				max = pozycja1;
				mniejsze = tab2;
				min = pozycja2;
			}
			//System.out.println(tab1[0]);
			Arrays.sort(tab1, 0, pozycja1);
			Arrays.sort(tab2, 0, pozycja2);
			//System.out.println(tab1[0]);
			
			/*
			for(int e : wieksze)
			{
				System.out.print( e);
			}
			
			System.out.print(" ");
			
			for(int e : mniejsze)
			{
				System.out.print( e);
			}
			System.out.println();
			*/


			int suma = 0;	
			int TabNext=0;
			
			for(int j=0; j<max; j++)
			{
				for(int k=TabNext; k<min; k++)
				{
					if(wieksze[j] == mniejsze[k])
					{
						suma++;
						TabNext = k+1;
						//System.out.println("Liczba podobnych znaków: " + suma + " Podobieñstwa: " + wieksze[j] + " = " + mniejsze[k]);
						break;
					}
					else if(wieksze[j] >= mniejsze[k])
					{
						TabNext = k;
						//System.out.println("Nie znalaziono podobnego znaku! Szukam dalej... chrum chrum");
						continue;
					}
					else if(wieksze[j] < mniejsze[k] )
					{
						TabNext = k;
						//System.out.println("Nie znalaziono podobnego znaku! Przekroczy³em wymagane wartoœci :(");
						break;
					}
				}
			}
			suma = min - suma;
			
			//System.out.print(max + " | " + min + " suma: ");
			System.out.println(suma);			
		}
	}

	public static int readInt(BufferedReader br) throws IOException
	{
		//Wczytywaj znaki (spacje, entery i takie tam) az bedzie jakas cyfra (minus zmienia na ujemna)
		int znak;
		int wynik = 0;
		int znakLiczby = 1;
		do 
		{
			znak = br.read();
			if (znak == '-')
			{
				znakLiczby = -1;
				continue;
			}
		} while (znak < '0' || znak > '9');
		wynik = 0;
		//Wczytywaj cyfry i tworz inta, az napotkasz inny znak
		while ( (znak >= '0' && znak <= '9'))
		{
			wynik = wynik * 10 + znak - '0';
			znak = br.read();
		}
		return wynik * znakLiczby;
	}


}

