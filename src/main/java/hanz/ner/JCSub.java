package hanz.ner;

import hanz.types.NE;

import java.io.File;
import java.net.URLDecoder;

import org.apache.commons.lang.StringUtils;
import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import com.aliasi.chunk.Chunk;
import com.aliasi.chunk.Chunker;
import com.aliasi.util.AbstractExternalizable;

/**
 * this will get the gene
 * 
 * @author Han Zhang
 *
 */
public class JCSub extends JCasAnnotator_ImplBase {
  /**
   * get the chunk
   */
  Chunker chunker;

  /**
   * loads the model for chunker
   */
  @Override
  public void initialize(UimaContext aContext) throws ResourceInitializationException {
    // TODO Auto-generated method stub

    try {
      System.out.println((String) aContext.getConfigParameterValue("InpuString"));
      chunker = (Chunker) AbstractExternalizable.readResourceObject(JCSub.class,
              (String) aContext.getConfigParameterValue("InpuString"));
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
    }

    super.initialize(aContext);
  }

  /**
   * find the space
   * 
   * @param s
   *          sentence
   * @param u
   *          end index
   * @return number of spaces of substring s[0:u]
   */
  public static int Spaces(String s, int u) {
    return StringUtils.countMatches(s.substring(0, u), " ");
  }

  /**
   * get all the gene names
   * 
   * @param aJCas
   *          Cas contains senteces
   */
  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub

    String doc = aJCas.getDocumentText();
    for (Chunk chunk : chunker.chunk(doc).chunkSet()) {
      NE ne = new NE(aJCas);
      ne.setBegin(chunk.start() - Spaces(doc, chunk.start()));
      ne.setEnd(chunk.end() - Spaces(doc, chunk.end()) - 1);
      ne.setNEString(doc.substring(chunk.start(), chunk.end()));
      ne.addToIndexes();
    }

  }

}
