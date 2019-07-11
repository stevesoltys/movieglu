# Movieglu
[![Build Status](https://travis-ci.com/stevesoltys/movieglu.svg?branch=master)](https://travis-ci.org/stevesoltys/movieglu)

An [Movieglu](https://developer.movieglu.com/) API wrapper.

## Installation
```groovy
repositories {
    jcenter()
    maven { url 'https://jitpack.io' }
}

dependencies {
    compile 'com.github.stevesoltys:movieglu:0.1.0'
}
```

## Usage
Create a `Movieglu` instance with your credentials, and run an API query.

Here's an example:
```java
 Movieglu movieglu = Movieglu.builder()
    .apiEndpoint("https://api-gate2.movieglu.com/")
    .territory("US")
    .authorization("Basic Tk9ORV8zMjpIZFhQNmZYMHVyTYI=")
    .apiKey("bnaDP2aFJm2IVwmKXx3iC8zUvYIB9qWk57felpFF")
    .username("NONE_32")
    .deviceDateTime(Instant.now().toString())
    .build();

NowShowingResponse nowShowingResponse = movieglu.getNowShowing(10);
NowShowingFilm = nowShowingResponse.getFilms().get(0);

// ...
```

## License
This library is available as open source under the terms of the [MIT License](http://opensource.org/licenses/MIT).
