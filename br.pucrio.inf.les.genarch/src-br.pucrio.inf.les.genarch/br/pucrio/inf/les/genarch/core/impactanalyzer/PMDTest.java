package br.pucrio.inf.les.genarch.core.impactanalyzer;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import net.sourceforge.pmd.PMD;

import org.junit.Assert;
import org.junit.Test;

public class PMDTest {

    @Test
    public void testPMDSrc() throws Exception {
        doPMD("./src/");
    }

    private void doPMD(String sourceFolder) throws Exception {

    	PMD meu = new PMD();
    	
        // A friendly message informing we are going to start the test
        System.out.println("Starting PMD code analyzer test on directory '" + sourceFolder + "'..");

        // Init the arguments
        String filePath = new File(sourceFolder).getAbsoluteFile().toString();
        String outputType = "text";
        String unusedString = "this is an unsued variable";
        String rules = URLDecoder.decode(PMDTest.class.getResource("pmdrules.xml").getFile().toString(), "UTF-8");

        String[] arguments = new String[] { filePath, outputType, rules };

        // Save the streams to be restored after the test
        PrintStream out = System.out;
        PrintStream err = System.err;

        // Create our new streams to be hooked
        ByteArrayOutputStream baosOut = new ByteArrayOutputStream();
        ByteArrayOutputStream baosErr = new ByteArrayOutputStream();

        PrintStream psOut = new PrintStream(baosOut);
        PrintStream psErr = new PrintStream(baosErr);

        // Hook the streams with our own
        System.setOut(psOut);
        System.setErr(psErr);

        // Star the actual PMD test
        PMD.main(arguments);
      
        

        // Restore the default streams
        System.setOut(out);
        System.setErr(err);

        // Close everything up
        psOut.close();
        psErr.close();
        baosOut.close();
        baosErr.close();

        // Organize the output from the PMD test
        String linesOut[] = baosOut.toString().split("\\r?\\n");
        List rowsOut = new ArrayList();

        for (String line : linesOut) {
            if (line.length() > 0 && line.indexOf("suppressed by Annotation") == -1 && line.indexOf("No problems found!") == -1 && line.indexOf("Error while processing") == -1) {
                rowsOut.add(line);
            }
        }

        System.out.println("Found " + rowsOut.size() + " errors");
//        for (String error : rowsOut) {
//            System.out.println(error);
//        }

        if (baosErr.toString().length() > 0) {
            System.out.println("Errors:");
            System.out.println(baosErr.toString());
        }

        // JUnit asserts
        Assert. assertTrue(rowsOut.size() + " errors\n" + rowsOut.toString(), rowsOut.isEmpty());
        Assert. assertTrue(baosErr.toString(), baosErr.toString().trim().length() == 0);

    }
}
