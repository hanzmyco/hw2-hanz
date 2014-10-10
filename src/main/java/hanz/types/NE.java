

/* First created by JCasGen Tue Oct 07 22:42:08 EDT 2014 */
package hanz.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import edu.cmu.deiis.types.Annotation;


/** 
 * Updated by JCasGen Tue Oct 07 22:42:08 EDT 2014
 * XML source: /Users/hanz/Desktop/Dropbox/Workspace/hw2-hanz/src/main/resources/descriptors/typeSystemDescriptor.xml
 * @generated */
public class NE extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(NE.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected NE() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public NE(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public NE(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public NE(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: NEString

  /** getter for NEString - gets 
   * @generated
   * @return value of the feature 
   */
  public String getNEString() {
    if (NE_Type.featOkTst && ((NE_Type)jcasType).casFeat_NEString == null)
      jcasType.jcas.throwFeatMissing("NEString", "hanz.types.NE");
    return jcasType.ll_cas.ll_getStringValue(addr, ((NE_Type)jcasType).casFeatCode_NEString);}
    
  /** setter for NEString - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setNEString(String v) {
    if (NE_Type.featOkTst && ((NE_Type)jcasType).casFeat_NEString == null)
      jcasType.jcas.throwFeatMissing("NEString", "hanz.types.NE");
    jcasType.ll_cas.ll_setStringValue(addr, ((NE_Type)jcasType).casFeatCode_NEString, v);}    
  }

    