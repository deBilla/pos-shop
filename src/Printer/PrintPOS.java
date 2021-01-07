/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Printer;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Arrays;
/**
 *
 * @author Dimuthu
 */
public class PrintPOS {
    
    public void printToPrinter(String printData)
    {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new OutputPrinter(printData));
        boolean doPrint = job.printDialog();
        if (doPrint)
        { 
            try 
            {
                job.print();
            }
            catch (PrinterException e)
            {
                // Print job did not complete.
            }
        }
    }
    
    public void printToPOS(String printData)
    {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new OutputPrinter(printData));        
        try 
        {
            job.print();
        }
        catch (PrinterException e)
        {
            // Print job did not complete.
        }
    }
}
