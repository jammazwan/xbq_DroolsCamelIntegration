### DroolsCamelIntegration NOTES:

High level overview:

 * Establishes FileMaintainer as a hack, to contain drools engine startup, and all project code except the Camel route.
 * Uses standard camel file routing to iterate through files in this project root
 * Launches through jammazwan.xbq.XbqTest, a junit test.
 * Camel route finds pom.xml, NOTES.md, README.md files in this project root
 * Camel route does not find EXTRA.md, or Jenkinsfile.
 * For each file found, sets appropriate boolean in FileMaintainer class
 * Drools then reads FileMaintainer and checks for which files exist, firing rules accordingly.
 * Sets a global _Set_ member for each desired file found
 * Junit test checks global Set for existence of desired members
 
### Integration notes re: Drools

The Drools integration in this project is as close to the exact minimum code that could be found to work, and was designed for brevity and conciseness rather than any ideas about good design or appropriate Drools usage.

It should be regarded as a proof of concept only, and in no way representative of proper Drools coding practices. 

Please consult [Drools documentation](http://docs.jboss.org/drools/release/6.4.0.Final/drools-docs/html_single/index.html) for proper coding guidelines and practices.

On a separate note, we had some trouble getting the pom.xml to work consistently over time, and what is shown in this project is just what was found to work at time of initial commit. You may, or may not, find additional tweaks with the Drools dependencies to be necessary over time. Also see credits below.

### Integration notes re: Camel

As per notes above, this project is a proof of concept only and may not be representative of how you might integrate Drools with Camel in production code.

### Special Credits - Mark Meandro, Gerald Cantor

This project would not be working without the help of Mark Meandro, _Camel/Fuse/RedHatTooling developer extraordinaire_. He led me to the initial maven archetype which we used to seed the project initially, and then later, when this quit working, debugged the pom dependencies to get it working again. This is the kind of guy you want on your team, for sure.

The original idea for a camel/drools integration came from Gerald Cantor over beers. Gerald has more experience with Camel than all but a few living humans, and I was lucky to get his insights for this project.
 
 
