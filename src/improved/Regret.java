/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package improved;
import java.text.DecimalFormat;
import java.util.ArrayList;
/**
 *
 * @author admin
 */
public class Regret 
{
    Details dt=new Details();
    DecimalFormat df=new DecimalFormat("#.###");
    double time=0;
    Regret(int tm)
    {
        time=(double)tm;
    }
    
    public void find()
    {
        try
        {
            dt.Reg=new double[dt.Agent][dt.State];
            
            if(time>0)
            {
                
                double agt[]=new double[dt.Agent];
                for(int i=0;i<dt.Agent;i++)
                {
                    double sm=0;
                    for(int j=0;j<dt.State;j++)
                    { 
                        sm=sm+dt.Rew[i][j];
                    }
                    sm=sm/dt.State;                    
                    agt[i]=sm;
                }
                
                
                
                for(int i=0;i<dt.Agent;i++)
                {
                    for(int j=0;j<dt.State;j++)
                    {       
                        double sm1=0;
                        for(int k=0;k<dt.Agent;k++)
                        {
                            if(i!=k)
                                sm1=sm1+agt[k];
                        }
                        sm1=sm1/dt.Agent-1;
                                               
                        double nm=Math.abs(sm1-dt.Rew[i][j]);                       
                        
                        dt.Reg[i][j]=nm;
                    }
                }
                
                System.out.println("Regret =================");
                
                for(int i=0;i<dt.Agent;i++)
                {
                    for(int j=0;j<dt.State;j++)
                    {       
                        double sm1=0;
                        for(int k=0;k<dt.Agent;k++)
                        {
                            if(i!=k)
                                sm1=sm1+agt[k];
                        }
                        sm1=sm1/dt.Agent-1;
                                               
                        double nm=Math.abs(sm1-dt.Rew[i][j]);                       
                        
                        
                        double ks=(((time-1)/time)*dt.Reg[i][j])+((1/time)*nm);
                        dt.Reg[i][j]=Double.parseDouble(df.format(ks));
                        System.out.print(df.format(ks)+" ");
                    }
                    System.out.println();
                }
                
                
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
