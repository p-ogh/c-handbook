package testdome.java;

public class CacheCasting {

    //A company is designing the class hierarchy for various cache implementations:
    //public class Cache {}
    //public class DiskCache extends Cache {}
    //public class MemoryCache extends Cache {}
    //public class OptimizedDiskCache extends DiskCache {}

    //Select all the answers that will result in a runtime exception.
    //Hint: You can create a SuperClass from ChildClass, casting a ChildClass from SuperClass will result in runtime error.



    //answers that will result in error

    //MemoryCache memoryCache = new MemoryCache();
    //Cache cache = (Cache) memoryCache;
    //DiskCache diskCache = (DiskCache) cache;


    //DiskCache diskCache = new DiskCache();
    //OptimizedDiskCache optimizedDiskCache = (OptimizedDiskCache) diskCache;


    //Cache cache = new Cache();
    //MemoryCache memoryCache = (MemoryCache) cache;

}
