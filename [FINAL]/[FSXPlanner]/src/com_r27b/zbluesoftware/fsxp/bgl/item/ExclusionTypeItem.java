// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ExclusionTypeItem.java

package com.zbluesoftware.fsxp.bgl.item;


// Referenced classes of package com.zbluesoftware.fsxp.bgl.item:
//            Item

public class ExclusionTypeItem extends Item
{

    public ExclusionTypeItem()
    {
        this("type", 4);
    }

    public ExclusionTypeItem(String name, int bit)
    {
        this(name, bit, "Word", 2);
    }

    public ExclusionTypeItem(String name, int bit, String dataType, int length)
    {
        this.name = name;
        this.bit = bit;
        this.dataType = dataType;
        this.length = length;
        offset = 0;
        hexData = null;
        decodedData = null;
    }

    public void setDecodedData()
    {
        String tempHex = hexData.replaceAll(" ", "");
        StringBuffer buffer = new StringBuffer();
        for(int i = tempHex.length() - 1; i >= 0; i -= 2)
            buffer.append(tempHex.charAt(i - 1)).append(tempHex.charAt(i));

        int tempData = Long.valueOf(buffer.toString(), 16).intValue();
        int testValue = (int)Math.pow(2D, bit);
        if(bit == -1)
        {
            if(tempData == 8)
                decodedData = "TRUE";
            else
                decodedData = "FALSE";
        } else
        if((tempData & testValue) > 0)
            decodedData = "TRUE";
        else
            decodedData = "FALSE";
    }

    private int bit;
}
