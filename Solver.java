import java.io.*;
import java.util.List;
import java.util.ArrayList;

import facilitysolver.LocalSearch;
import facilitysolver.Solution;

public class Solver 
{ 
    /**
     * The main class
     */
    public static void main(String[] args) 
    {
        try 
        {
            solve(args);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    
    /**
     * Read the instance, solve it, and print the solution in the standard output
     */
    public static void solve(String[] args) throws IOException 
    {
        String fileName = null;
        
        // get the temp file name
        for(String arg : args)
        {
            if(arg.startsWith("-file="))
            {
                fileName = arg.substring(6);
            } 
        }
        if (fileName == null)
            return;
        
        // read the lines out of the file
        List<String> lines = new ArrayList<String>();

        BufferedReader input =  new BufferedReader(new FileReader(fileName));
        try 
        {
            String line = null;
            while (( line = input.readLine()) != null)
            {
                lines.add(line);
            }
        }
        finally 
        {
            input.close();
        }
        
        Solution solution = LocalSearch.solve(lines);
        
        System.out.println(solution.cost + " " + solution.optimal);
        for (int i = 0; i < solution.customers.length; i++)
        {
            System.out.print(solution.customers[i] + " ");
        }
        System.out.println("");        
    }
}