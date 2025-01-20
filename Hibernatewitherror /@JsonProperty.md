To fix the issue where the `name` and `model` fields are coming out as `null` in your output, follow these steps:

### 1. **Ensure Correct JSON Mapping in the Controller**:
In your `ProductController`, you need to ensure that the incoming JSON is correctly mapped to the `ProductModel` object. You should use `@RequestBody` to ensure the JSON is bound to the `ProductModel` object.

#### Fix in `ProductController`:
```java
import org.springframework.web.bind.annotation.RequestBody;

@PostMapping("/input")
public ProductModel toAddProduct(@RequestBody ProductModel model) {
    return service.addModel(model);
}
```
- `@RequestBody` ensures that the incoming data in the body of the `POST` request is automatically mapped to the `ProductModel` object.

### 2. **Ensure Field Name Consistency**:
The field names in the incoming JSON should match the names of the properties in your `ProductModel` class. From your original JSON, it looks like you're using different field names (e.g., `prodname` and `prodid`) than what is in your model (`name`, `id`).

#### Option 1: Modify the Input JSON to Match the Model:
Update your `POST` request body to match the field names in your `ProductModel` class:
```json
{
    "name": "Product C",
    "id": 1030,
    "price": 2000000,
    "model": "Model XYZ"
}
```
This should match the field names in your `ProductModel` class (`name`, `id`, `price`, `model`).

#### Option 2: Use `@JsonProperty` to Map JSON Field Names:
If you need to keep the field names in the JSON as `prodname` and `prodid`, you can use the `@JsonProperty` annotation in your `ProductModel` to map them correctly.

Update your `ProductModel` class like this:

```java
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("prodname")
    private String name;

    @Column(name="price")
    private int price;

    @JsonProperty("prodid")
    private String model;

    // Constructors, getters, and setters
    public ProductModel() {}

    public ProductModel(String name, int price, String model) {
        this.name = name;
        this.price = price;
        this.model = model;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
```
- `@JsonProperty("prodname")` and `@JsonProperty("prodid")` will ensure that the incoming JSON keys (`prodname`, `prodid`) are correctly mapped to the Java class fields (`name`, `model`).

### 3. **Verify `GET` Request**:
Ensure that your `GET` request properly returns the stored data:

```java
@GetMapping("/input")
public List<ProductModel> toShowProduct() {
    return service.toShowproduct();
}
```

This will fetch all the products from the database, and if everything is mapped correctly, the data should include the correct values.

### 4. **Test the Solution**:
After making these changes, test the following:
1. Send a `POST` request with the correct JSON (either matching the field names or using `@JsonProperty`).
2. Verify the data is being saved correctly in the database.
3. Send a `GET` request to see if the data is retrieved correctly, with the `name` and `model` fields populated.

### Example JSON for Testing:
If you're using `@JsonProperty` as shown in Option 2, send the following JSON in your `POST` request:
```json
{
    "prodname": "Product C",
    "prodid": 1030,
    "price": 2000000
}
```

If you're using the standard field names (without `@JsonProperty`), send:
```json
{
    "name": "Product C",
    "id": 1030,
    "price": 2000000,
    "model": "Model XYZ"
}
```

This should resolve the issue of `null` or default values in your output.
