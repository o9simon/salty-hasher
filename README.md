# Salty Hasher
Small library to hash strings with MD5 and SHA1 using different salt algorithms.

## Usage
```java
SaltyHasher hasher = new SaltyHasher();
hasher.md5("string_to_hash", "salt_value", SaltyHasher.BEFORE);
hasher.sha1("string_to_hash", "salt_value", SaltyHasher.BEFORE);
```

## Salt algorithms
* SaltyHasher.BEFORE will prepend the salt to the string to hash.
* SaltyHasher.AFTER will append the salt to the string to hash.
* SaltyHasher.MIDDLE will insert the salt in the middle of the string to hash.
* SaltyHasher.INTERLACE_0 will interlace the salt and the string to hash starting with the string to hash.
* SaltyHasher.INTERLACE_1 will interlace the salt and the string to hash starting with the salt.
