<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="employees">
        <html>
            <body>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="employee">
        <b><xsl:value-of select="age" /></b>
        <b><xsl:value-of select="name" /></b>
        <b><xsl:value-of select="salary" /></b>
        <b><xsl:value-of select="qualification" /></b>
        <b><xsl:value-of select="male" /></b><br/>
    </xsl:template>
</xsl:stylesheet>