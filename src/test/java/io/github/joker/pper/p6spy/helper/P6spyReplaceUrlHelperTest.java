package io.github.joker.pper.p6spy.helper;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class P6spyReplaceUrlHelperTest {

    @Test
    public void getResolvedResult() {

        Assert.assertEquals(null, P6spyReplaceUrlHelper.getResolvedResult(null));
        Assert.assertEquals("", P6spyReplaceUrlHelper.getResolvedResult(""));

        Assert.assertEquals("jdbc:p6spy:mysql://localhost:3306/db", P6spyReplaceUrlHelper.getResolvedResult("jdbc:mysql://localhost:3306/db"));

        Assert.assertEquals("jdbc:p6spy:mariadb://localhost:3306/db", P6spyReplaceUrlHelper.getResolvedResult("jdbc:mariadb://localhost:3306/db"));

        Assert.assertEquals("jdbc:p6spy:oracle:thin:@localhost:1521:db", P6spyReplaceUrlHelper.getResolvedResult("jdbc:oracle:thin:@localhost:1521:db"));

        Assert.assertEquals("jdbc:p6spy:oceanbase://localhost:3306/db", P6spyReplaceUrlHelper.getResolvedResult("jdbc:oceanbase://localhost:3306/db"));

        Assert.assertEquals("jdbc:p6spy:sqlserver://localhost:1433;DatabaseName=db", P6spyReplaceUrlHelper.getResolvedResult("jdbc:sqlserver://localhost:1433;DatabaseName=db"));
        Assert.assertEquals("jdbc:p6spy:microsoft:sqlserver://localhost:1433;DatabaseName=db", P6spyReplaceUrlHelper.getResolvedResult("jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=db"));

        Assert.assertEquals("jdbc:p6spy:postgresql://localhost:5432/db", P6spyReplaceUrlHelper.getResolvedResult("jdbc:postgresql://localhost:5432/db"));

        Assert.assertEquals("jdbc:p6spy:sybase:Tds:localhost:5000/db", P6spyReplaceUrlHelper.getResolvedResult("jdbc:sybase:Tds:localhost:5000/db"));
        Assert.assertEquals("jdbc:p6spy:jtds:sybase://localhost:5000/db", P6spyReplaceUrlHelper.getResolvedResult("jdbc:jtds:sybase://localhost:5000/db"));

        Assert.assertEquals("jdbc:p6spy:db2://localhost:50000/db", P6spyReplaceUrlHelper.getResolvedResult("jdbc:db2://localhost:50000/db"));

        Assert.assertEquals("jdbc:p6spy:h2:tcp://localhost/~/db", P6spyReplaceUrlHelper.getResolvedResult("jdbc:h2:tcp://localhost/~/db"));

        Assert.assertEquals("jdbc:p6spy:other://localhost:3306/db", P6spyReplaceUrlHelper.getResolvedResult("jdbc:other://localhost:3306/db"));
        Assert.assertEquals("jdbc:p6spy:test://localhost:3306/db", P6spyReplaceUrlHelper.getResolvedResult("jdbc:test://localhost:3306/db"));

    }
}