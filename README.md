<br>
<br>
<p align="center"><img title="Caviel Figgy Library Logo" src="https://i.imgur.com/IgQKtS4.png"></p>
<br>
<p align="center">The Easy File Editor & Parser</p>
<p align="center">
<img src="https://badge.fury.io/gh/Caviel%2Ffiggy.svg">
<img src="https://travis-ci.com/Caviel/Figgy.svg?branch=master">
</p>
<br>

## Introduction

Figgy for Java helps you parse and edit configuration files such as YML, JSON, conf, properties and more with zero other resources except for this!

## Supported File Types
Here is a full list of the file types we *aim* to support!

* [YAML](https://yaml.org) - In progress!
* [JSON](https://www.json.org/json-en.html) - In progress!
* [.conf](https://conf.splunk.com/) - In progress!
* [.properties](https://docs.oracle.com/cd/E23095_01/Platform.93/ATGProgGuide/html/s0204propertiesfileformat01.html) - In progress!
* [TOML](https://toml.io/en/) - In progress!
* [XML](http://www.xml.org/) - In progress!
* [.env](https://www.ibm.com/support/knowledgecenter/ssw_aix_72/osmanagement/env_file.html#:~:text=%3D%24HOME%2F.env-,The%20.,your%20individual%20working%20environment%20variables.&text=env%20file%20contains%20the%20individual,env%20file.) - In progress!
* [.ini](https://en.wikipedia.org/wiki/INI_file) - In progress!

In addition to this, we also support our own .fig files and you can create your own type by defining a custom fig parser object in your code, using either a base type or a key charector/value charector regex.
