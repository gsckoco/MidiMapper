
# MidiMapper
Midi Mapper makes mapping MIDI device notes into keyboard output, mouse output or back out into a MIDI device.
# Reason
I decided to begin this mainly to give me something too do. Along with being bored out of my mind I also decided to specifically make something MIDI related as it's something I would personally use a lot and replace the overly expensive Bome's MIDI Translator.
# Installation
There are currently no releases for this program, so there is no way to install it unless you build it yourself.
# Building
Pretty simple; If you are using IntelliJ Idea open up Project Structure (```ctrl+alt+shift+s``` amazing I know) and go to `Artifacts` and create a new Artifact of the `JavaFX Application` type.
![Add>JavaFX Application > From module 'MidiMapper'](https://i.gsck.co.uk/Huproahez.png)

Congratulations you created an artifact! Next you need to go too the `Java FX` tab. Set the `Application class` too `co.uk.gsck.midi.mapper.Main`, skip a few of the inputs, you can fill them in if you wish, go down to the drop down window `Native bundle` and select the doofer you need, use `all` for all possible executable's too be made.
# Screenshots
Soon. The program doesn't even allow you to do anything with the Midi inputs yet, give me a chance!
# Contributing
If you are interested in contributing then feel free to make `pull requests`. However please note that if you haven't a clue about Java then don't create a `pull request`, instead create an `Issue`.
## Pull Requests
When creating a pull request make sure that your code works.
Please also provide us with the following;

 - Operating systems you have tested on
 - What the edit does to the code, what does it make better, what does it add.

## Issues
When creating an issue please give us as much information as possible, such as;

 - A step by step guide to reproducing
 - Behaviour of the bug
 - If possible an error log (Usually only shows up if you are running said program directly through Java as a jar in the command line)
 - System information 
	 - Operating system
	 - Build version (If any)
	 - MIDI Device model (e.g. Akai APC Mini)
 - ~~Your soul~~
