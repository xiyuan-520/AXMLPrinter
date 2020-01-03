/* -*-             c-basic-offset: 4; indent-tabs-mode: nil; -*-  //------100-columns-wide------>|*/
// for license please see accompanying LICENSE.txt file (available also at http://www.xmlpull.org/)

package org.xmlpull.v1;

/**
 * This exception is thrown to signal XML Pull Parser related faults.
 *
 * @version v1.0.0 @author lgz 2020-1-3 新建与整理
 */
public class XmlPullParserException extends Exception {
    private static final long serialVersionUID = 1L;
    protected Throwable detail;
    protected int row = -1;
    protected int column = -1;

   
    public XmlPullParserException(String s) {
        super(s);
    }
    public XmlPullParserException(String msg, XmlPullParser parser, Throwable chain) {
        super ((msg == null ? "" : msg+" ")
               + (parser == null ? "" : "(position:"+parser.getPositionDescription()+") ")
               + (chain == null ? "" : "caused by: "+chain));

        if (parser != null) {
            this.row = parser.getLineNumber();
            this.column = parser.getColumnNumber();
        }
        this.detail = chain;
    }

    public Throwable getDetail() { return detail; }
    public int getLineNumber() { return row; }
    public int getColumnNumber() { return column; }

    public void printStackTrace() {
        if (detail == null) {
            super.printStackTrace();
        } else {
            synchronized(System.err) {
                System.err.println(super.getMessage() + "; nested exception is:");
                detail.printStackTrace();
            }
        }
    }

}

