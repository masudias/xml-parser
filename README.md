# xml-parser
There is a export.xml file in the directory which includes some data. 

We need to search for a specific type = `HKQuantityTypeIdentifierStepCount`

Here is a sample record of the type specified. 

```xml
<Record type="HKQuantityTypeIdentifierStepCount" sourceName="Gokila’s iPhone" sourceVersion="11.2.1" device="&lt;&lt;HKDevice: 0x28090a440&gt;, name:iPhone, manufacturer:Apple, model:iPhone, hardware:iPhone10,1, software:11.2.1&gt;" unit="count" creationDate="2018-01-26 14:50:05 -0500" startDate="2018-01-26 14:16:39 -0500" endDate="2018-01-26 14:24:29 -0500" value="20"/>
```

The expected output should be a CSV file as follows:
 
```
File Name: StepCount.csv
Source Name, Source Version, Creation Date, Value
Gokila’s Apple Watch, 5.1.3, 2019-03-05 10:55:24, 30
```
The generated file `StepCount.csv` is added in the directory as well.

There is another main class in this project which is `ReadInfoPlist`. This contains the parsing from a plist file where xmlwise library from Google was used for parsing. 
