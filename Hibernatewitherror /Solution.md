The `@JsonProperty` annotation in Java is used to bind a JSON property (field) from an incoming JSON request to a specific field in a Java class. It is a part of the Jackson library, which is commonly used for serializing and deserializing Java objects to and from JSON.

### Key Use Cases of `@JsonProperty`:
1. **Mapping JSON Fields to Java Fields with Different Names**:
   - When the field names in your JSON do not match the field names in your Java class, you can use `@JsonProperty` to specify the JSON field that should be mapped to the Java field.
   
2. **Renaming Fields for Deserialization**:
   - You can rename a field in Java (for example, `product_name`) to match a differently named field in the JSON (for example, `prodname`), using `@JsonProperty`.

3. **Handling Optional Fields**:
   - You can use `@JsonProperty` to specify which JSON fields are required or optional during serialization/deserialization.

### How `@JsonProperty` Works:
When Spring (or any Java framework using Jackson) encounters a JSON string during deserialization, it looks for keys in the JSON that correspond to fields in the Java class. If the names match, the value is automatically mapped to the corresponding Java field. If the names differ, you can use the `@JsonProperty` annotation to tell Jackson which JSON field corresponds to the Java field.

#### Syntax:
```java
@JsonProperty("json_field_name")
private String javaField;
```

### Example 1: Basic Use of `@JsonProperty`
Suppose you have a JSON object with a field `prodname` and a Java class with a field `name`:
#### Input JSON:
```json
{
    "prodname": "Product A",
    "price": 1000
}
```

#### Java Class:
```java
import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
    
    @JsonProperty("prodname")
    private String name;

    private int price;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
```

### Explanation:
- **JSON Field**: The JSON field `prodname` needs to be mapped to the `name` field in the Java class.
- **`@JsonProperty("prodname")`**: This annotation tells Jackson that the JSON field `prodname` should be mapped to the `name` property in the `Product` class.
- When the JSON is deserialized, Jackson automatically maps the value of `prodname` to the `name` field in the `Product` class.

#### Output (after deserialization):
The `Product` object will look like:
```java
Product{name="Product A", price=1000}
```

### Example 2: Mapping Multiple JSON Fields to Java Fields
If the JSON has multiple fields that need to be mapped to Java fields with different names, you can use `@JsonProperty` for each mapping.

#### Input JSON:
```json
{
    "prodname": "Product A",
    "product_price": 1000,
    "prod_model": "Model X"
}
```

#### Java Class:
```java
import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {

    @JsonProperty("prodname")
    private String name;

    @JsonProperty("product_price")
    private int price;

    @JsonProperty("prod_model")
    private String model;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
```

#### Explanation:
- **JSON Fields**:
  - `prodname` → `name`
  - `product_price` → `price`
  - `prod_model` → `model`
- **`@JsonProperty` Annotations**:
  - `@JsonProperty("prodname")` maps the JSON field `prodname` to the `name` property in the `Product` class.
  - `@JsonProperty("product_price")` maps the JSON field `product_price` to the `price` property in the `Product` class.
  - `@JsonProperty("prod_model")` maps the JSON field `prod_model` to the `model` property in the `Product` class.

#### Output (after deserialization):
The `Product` object will look like:
```java
Product{name="Product A", price=1000, model="Model X"}
```

### Example 3: Using `@JsonProperty` with Optional Fields
You can also specify whether a field should be required or optional using `@JsonProperty`.

#### Input JSON:
```json
{
    "prodname": "Product A",
    "price": 1000
}
```

#### Java Class (with `required`):
```java
import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {

    @JsonProperty(value = "prodname", required = true)
    private String name;

    @JsonProperty("price")
    private int price;

    // Getters and Setters
}
```

### Explanation:
- The `name` field is marked as `required = true` using `@JsonProperty`. This means that if the `prodname` field is missing in the input JSON, Jackson will throw an error during deserialization.
  
### Benefits of `@JsonProperty`:
1. **Field Name Flexibility**: You can use different field names in the JSON and Java class, allowing you to work with legacy systems or external APIs with different naming conventions.
2. **Custom Serialization/Deserialization**: You can control how fields are serialized (written to JSON) and deserialized (read from JSON).
3. **Field Requirement**: You can specify whether certain fields are required during deserialization, ensuring strict input validation.

### Conclusion:
- The `@JsonProperty` annotation is useful for customizing the mapping between JSON fields and Java fields.
- It can handle scenarios where the JSON field names differ from the Java field names.
- It provides flexibility in naming, and also allows you to set field-level requirements for JSON deserialization.

This is a powerful tool when dealing with complex or inconsistent JSON structures, or when you need to map fields with different names between JSON and Java objects.
