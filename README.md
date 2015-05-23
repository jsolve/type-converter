The recommended way to get started using type converter in your project is with a dependency management system – the snippet below can be copied and pasted into your build.
``` xml
<dependency>
	<groupId>pl.jsolve</groupId>
	<artifactId>typeconverter</artifactId>
  <version>1.0.1</version>
</dependency>
```
---

`TypeConverter` is a utility class that makes type conversion very easy. It's very fast and extendable.
## Simple usage
``` java
Target convertedObject = TypeConverter.convert(objectThatWillBeConverted, Target.class);
```
so for example to convert `String` to `Double`
``` java
Double result = TypeConverter.convert("12", Double.class);
```
## Supported conversions
Multiple conversions are supported out of the box. Take a look at the following list:
 - `Boolean` <-> `Integer`
 - `String` <-> `Number`
 - `Number` <-> `Number`
 - `Long` <-> `java.util.Date`,
 - `Long` <-> `java.util.Calendar`,
 - `java.util.Date` <-> `java.util.Calendar`.
 - `Array` <-> `Collection`
 - `Collection` <-> `Collection`
 - `Object` -> `String`

**Primitives are also supported.**
## Custom converters
When not a single converter listed above satisfies your needs you can easily "teach" `TypeConverter` new conversion. To do so you need to create and register your own converter.
### Creating converters
To create new converter just create a class that implements `Converter` interface, i.e.:
``` java
class ObjectToStringConverter implements Converter<Object, String> {

   @Override
   public String convert(Object source) {
      return source.toString();
   }
}
```
or an anonymous class:
``` java
Converter objectToStringConverter = new Converter<Object, String>() {
   @Override
   public String convert(Object source) {
      return source.toString();
   }
};
```
Converters created above will work for all classes as every class in Java extends `Object`.
### Registering converters
To register new converter use `TypeConveter.registerConverter` method. Suppose we have a converter called `converter` that supports conversion from type `Source` to type `Target`.
``` java
TypeConverter.registerConverter(Source.class, Target.class, converter);
```
Our newly registered converter from `Source.class` to `Target.class` will override any already registered converter that supports the same conversion.
### Unregistering converters
To unregister converter from `Source.class` to `Target.class`:
``` java
TypeConverter.unregisterConverter(Source.class, Target.class);
```
