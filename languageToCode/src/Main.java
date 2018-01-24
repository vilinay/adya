import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;


import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.util.InvalidFormatException;

public class Main {
public String input="This is the sentence detector. This will separate the commands out othe given instructions. Using sentence analyser";
        try {
            new Main().sentenceDetect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sentenceDetect() throws InvalidFormatException, IOException {
        String paragraph = "Apache openNLP supports the most common NLP tasks, such as tokenization, sentence segmentation, part-of-speech tagging, named entity extraction, chunking, parsing, and coreference resolution. These tasks are usually required to build more advanced text processing services. OpenNLP also includes maximum entropy and perceptron based machine learning.";

        // refer to model file "en-sent,bin", available at link http://opennlp.sourceforge.net/models-1.5/
        InputStream is = new FileInputStream("C:/vvp/adya/adya/lib/en-sent.bin");
        SentenceModel model = new SentenceModel(is);

        // load the model
        SentenceDetectorME sdetector = new SentenceDetectorME(model);

        // detect sentences in the paragraph
        String sentences[] = sdetector.sentDetect(paragraph);

        // print the sentences detected, to console
        for(int i=0;i<sentences.length;i++){
            System.out.println(sentences[i]);
        }
        is.close();
    }
}