package hanz.ner;

import hanz.types.NE;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import abner.Tagger;

public class AbnerAnnotator extends JCasAnnotator_ImplBase {
  private Tagger tagger;
  
  @Override
  public void initialize(org.apache.uima.UimaContext aContext) throws org.apache.uima.resource.ResourceInitializationException {
    tagger = new Tagger();
  };
  
  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    String doc = aJCas.getDocumentText();
    String [][] ents = tagger.getEntities(doc);
    for (String ent : ents[0]) {
      NE ne = new NE(aJCas);
      int pos = doc.indexOf(ent);
      if (pos != -1 && ent.length() < 10) {
        ne.setBegin(pos - JCSub.Spaces(doc, pos));
        ne.setEnd(pos + ent.length() - JCSub.Spaces(doc, pos + ent.length()) - 1);
        ne.setNEString(ent);
        ne.addToIndexes();
      }
    }
  }

}
