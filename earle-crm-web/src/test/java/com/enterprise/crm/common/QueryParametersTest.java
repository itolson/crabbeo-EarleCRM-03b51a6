package com.enterprise.crm.common;



import static com.enterprise.crm.common.QueryParameters.withParameters;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import org.junit.After;
import static org.junit.Assert.assertThat;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class QueryParametersTest {
    // class under test
    private QueryParameters classUnderTest;

    @After
    public void teardown() {
        classUnderTest = null;
    }

    @Test
    public void testWithParameters() {
        classUnderTest = withParameters("NAME", "VALUE");
        assertThat(classUnderTest, notNullValue());
    }

    @Test
    public void testAnd() {
        classUnderTest = withParameters("NAME1", "VALUE1");
        assertThat(classUnderTest, notNullValue());
        assertThat(classUnderTest.and("NAME2", "VALUE2"), is(classUnderTest));
    }

    @Test
    public void testEntries() {
        final Set<Map.Entry<String, Object>> expected = new HashSet<Map.Entry<String, Object>>();
        classUnderTest = withParameters("NAME1", "VALUE1").and("NAME2", "VALUE2");
        assertThat(classUnderTest, notNullValue());
        assertThat(classUnderTest.entries(), is(expectedParameterEntrySet()));
    }

    private Set<Map.Entry<String, Object>> expectedParameterEntrySet() {
        final Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("NAME1", "VALUE1");
        parameters.put("NAME2", "VALUE2");
        return parameters.entrySet();
    }
}
