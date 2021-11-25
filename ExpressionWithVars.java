package com.example.experiment4;

public class ExpressionWithVars extends Expression{
    private String m_strExp;
    private String m_strVar;

    public ExpressionWithVars(String strExp, String var)
    {
        m_strExp = strExp;
        m_strVar = var;
    }

    public double evalf(double d)
    {
        String str = m_strExp.replace(m_strVar, d+"");
        d = super.evalf(str);
        return d;
    }
}
