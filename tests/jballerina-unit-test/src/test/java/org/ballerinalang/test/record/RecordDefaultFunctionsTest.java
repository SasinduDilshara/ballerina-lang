/*
 *  Copyright (c) 2024, WSO2 LLC. (http://www.wso2.com).
 *
 *  WSO2 LLC. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied. See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.ballerinalang.test.record;

import org.ballerinalang.test.BCompileUtil;
import org.ballerinalang.test.BRunUtil;
import org.ballerinalang.test.CompileResult;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Test cases for record default functions in Ballerina.
 */
public class RecordDefaultFunctionsTest {

    private CompileResult compileResult;

    @BeforeClass
    public void setup() {
        compileResult = BCompileUtil.compile("test-src/record/record_default_functions.bal");
    }

    @Test(description = "Test record type with function invocations for default values")
    public void testRecordWithDefaultFunction() {
        Object returns = BRunUtil.invoke(compileResult, "recordDefaultFunctionWithArgument");
        Object returns2 = BRunUtil.invoke(compileResult, "recordDefaultFunction");
        Assert.assertNotNull(returns);
        Assert.assertNotNull(returns2);
    }

    @AfterClass
    public void tearDown() {
        compileResult = null;
    }
}
