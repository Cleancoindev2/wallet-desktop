package com.credits.general.util.variant;

import com.credits.general.pojo.VariantData;
import com.credits.general.pojo.VariantType;
import com.credits.general.util.GeneralConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

import static com.credits.general.util.variant.VariantUtils.COLLECTION_VALUES_DELIMITER;
import static com.credits.general.util.variant.VariantUtils.MAP_KEY_VALUE_DELIMITER;

@RunWith(Parameterized.class)
public class VariantUtilsTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(VariantUtilsTest.class);

    @Parameter
    public String classname;

    @Parameter(1)
    public String value;

    @Parameters(name = "{0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Boolean", null},
                {"boolean", ""},
                {"boolean", "false"},
                {"Boolean", "true"},
                {"Byte", "12"},
                {"byte", "13"},
                {"Short", "12"},
                {"short", "13"},
                {"Integer", "14"},
                {"int", "15"},
                {"Long", "999999999999999"},
                {"long", "1000000000000001"},
                {"Float", "999.99"},
                {"float", "10001.01"},
                {"Double", "9999999999.99"},
                {"double", "10000000001.01"},
                {"Double[]", String.format("1%s2", COLLECTION_VALUES_DELIMITER)},
                {"Set<String>", String.format("3%s4", COLLECTION_VALUES_DELIMITER)},
                {"List<Float>", String.format("5.3%s6.4", COLLECTION_VALUES_DELIMITER)},
                {"Map<String, String>", String.format(
                        "7%s8%s9%s10",
                        MAP_KEY_VALUE_DELIMITER,
                        COLLECTION_VALUES_DELIMITER,
                        MAP_KEY_VALUE_DELIMITER
                )},
        });
    }


    @Test
    public void test() {
        VariantData variantData = VariantUtils.createVariantData(classname, value);
        VariantType variantType = variantData.getVariantType();
        Object boxedValue = variantData.getBoxedValue();

        switch (variantType) {
            case ARRAY:
                VariantData[] variantDataArr = (VariantData[]) boxedValue;
                if (variantDataArr.length == 0) break;
                LOGGER.info("Input {{}: {}} -> VariantData {{}: {}}", classname, value, variantDataArr[0].getVariantType().name + "[]",
                        Arrays.stream(variantDataArr).map(variantDataElem -> {
                            return GeneralConverter.toString(variantDataElem.getBoxedValue());
                        }).collect(Collectors.joining(","))
                );
                break;
            case LIST:
                List<VariantData> variantDataList = (List<VariantData>) boxedValue;
                if (variantDataList.size() == 0) break;
                LOGGER.info("Input {{}: {}} -> VariantData {{}: {}}", classname, value, String.format("List<%s>", variantDataList.get(0).getVariantType().name),
                        variantDataList.stream().map(variantDataElem -> {
                            return GeneralConverter.toString(variantDataElem.getBoxedValue());
                        }).collect(Collectors.joining(","))
                );
                break;
            case SET:
                Set<VariantData> variantDataSet = (Set<VariantData>) boxedValue;
                if (variantDataSet.size() == 0) break;
                LOGGER.info("Input {{}: {}} -> VariantData {{}: {}}", classname, value, String.format("Set<%s>", variantDataSet.iterator().next().getVariantType().name),
                        variantDataSet.stream().map(variantDataElem -> {
                            return GeneralConverter.toString(variantDataElem.getBoxedValue());
                        }).collect(Collectors.joining(","))
                );
                break;
            case MAP:
                Map<VariantData, VariantData> variantDataMap = (Map<VariantData, VariantData>) boxedValue;
                if (variantDataMap.size() == 0) break;
                LOGGER.info("Input {{}: {}} -> VariantData {{}: {}}", classname, value,
                        String.format(
                                "Map<%s, %s>",
                                variantDataMap.keySet().iterator().next().getVariantType().name,
                                variantDataMap.values().iterator().next().getVariantType().name
                        ),
                        variantDataMap.entrySet().stream().map(entrySet -> {
                            return String.format(
                                    "%s:%s",
                                    entrySet.getKey().getBoxedValue(),
                                    entrySet.getValue().getBoxedValue()
                            );
                        }).collect(Collectors.joining(","))
                );
                break;
            default:
                LOGGER.info("Input {{}: {}} -> VariantData {{}: {}}", classname, value, variantType.name, GeneralConverter.toString(boxedValue));
        }
    }
}
