# More Validators(more-valid)
Additional Constraint Validators

## NotNullIfTrue

Validates that a field must not be null if another Boolean field is true.

### Example of usage
```java
@NotNullIfTrue(
      ifTrue="isSingle",
      notNull="motherName",
      message="If this person is not married please enter the mother name.")
public class Person {
    private Boolean isSingle;
    private String motherName;
    private Boolean isMarried;
    private String coupleName;

    public Boolean getIsSingle() {
        return isSingle;
    }

    public void setIsSingle(Boolean isSingle) {
        this.isSingle = isSingle;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public Boolean getIsMarried() {
        return isMarried;
    }

    public void setIsMarried(Boolean isMarried) {
        this.isMarried = isMarried;
    }

    public String getCoupleName() {
        return coupleName;
    }

    public void setCoupleName(String coupleName) {
        this.coupleName = coupleName;
    }

}
```

You can define a list of fields to validate:

```java
@NotNullIfTrue.List({
    @NotNullIfTrue(
            ifTrue="isSingle",
            notNull="motherName",
            message="If this person is not married please enter the mother name."),
    @NotNullIfTrue(
            ifTrue="isMarried",
            notNull="coupleName",
            message="If this person is married please enter the couple's name.")
})
public class Person {
    private Boolean isSingle;
    private String motherName;
    private Boolean isMarried;
    private String coupleName;

    public Boolean getIsSingle() {
        return isSingle;
    }

    public void setIsSingle(Boolean isSingle) {
        this.isSingle = isSingle;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public Boolean getIsMarried() {
        return isMarried;
    }

    public void setIsMarried(Boolean isMarried) {
        this.isMarried = isMarried;
    }

    public String getCoupleName() {
        return coupleName;
    }

    public void setCoupleName(String coupleName) {
        this.coupleName = coupleName;
    }

} 
```
