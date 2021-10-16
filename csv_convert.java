import java.io.*;

public class csv_convert {
    public static void main(String[] args) throws IOException {
        BufferedReader bru = new BufferedReader(new FileReader("E:\\2-1\\reserach\\alim sir\\brain\\SAVE_DATA\\tokitahmid1-1634365127867\\sad.txt"));
        String lin="";
        int c=0;
        String total="";
        while ((lin = bru.readLine()) != null) {
            if(lin.isEmpty())
            {
                total=total+'\n';
            }
            else if(lin.charAt(0)=='S')
                continue;

            else
                total=total+lin+",";
        }
        //System.out.println(total);
        //System.out.println(c);
        String token[]=total.split("\n\n");
        //System.out.println(token.length);

        FileWriter fileWriter = new FileWriter("E:\\2-1\\reserach\\alim sir\\brain\\csv convert\\convertedFile1.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter,true);

       // printWriter.print(222);



        String toAdd="count,Attention Level,delta Level,theta Level,low_alpha Level,high_alpha Level,low_beta Level,high_beta Level,low_gamma Level,mid_gamma Level\n";

        printWriter.print(toAdd);
        for(String x:token){
            int j=1;
            System.out.println(x);
            String tok[]=x.split(",");
            String fin="";
            for(String p:tok)
            {
                String a[]=p.split(":");
                if(j==10)
                {

                    fin=fin+a[1];
                }
                else{
                    j++;

                    fin=fin+a[1]+",";}
            }


            printWriter.print(fin+'\n');

        }
        printWriter.flush();
        printWriter.close();


    }
}
