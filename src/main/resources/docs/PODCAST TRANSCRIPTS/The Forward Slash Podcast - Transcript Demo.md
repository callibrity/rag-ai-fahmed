The Forward Slash Podcast  
Guest: Tyler Welton  
Date January 29, 2025  
URL: www.linktoshow.com/ep000

Tyler Welton ([00:02](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Discovering is easy. Fixing is hard. Fixing is really hard. It's a hard, in a way that I think most security people, and not knocking my security folks, but we don't understand. Been grateful to work around a lot of developers and understand really the complexity of a lot of that problem. But a lot of the solution needs to be distilling that down, answering those questions way quicker, right? Is, am I vulnerable to this? Yes or no? Do I have the information in front of me that I can make that decision as a developer? And so my hope is that, that that evolves.  
Aaron ([00:41](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Welcome to the Forward slash where we lean into the future of it. I'm your host, Aaron Chesney, with my beautiful co-host, James Carmen. Today we welcome into the fold Tyler Walton. Tyler Walton has been in information security for 15 plus years, serving in roles as engineer, pen tester, chief security officer and architect. He has pioneered new attacks against application development systems, co-written the O-W-A-S-P-C-I-C-D standard, and has spoken at conferences such as Defcon and BSides about his work. Tyler is the founder and CEO of Untamed Theory and Principal Security architect at Build Technologies. And he's going to be talking to us today about supply chain security. Welcome, Tyler.  
Tyler Welton ([01:33](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Thank you so much. It's great to be with you.  
James ([01:36](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

That was an awful great to have you.  
Aaron ([01:37](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

You know, speaking of security, I recently discovered I was a victim of identity theft. I was walking down the street and saw someone that looked just like me.  
James ([01:47](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Wow.  
Tyler Welton ([01:48](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Oh,.  
Tyler Welton ([01:53](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

It, the oof is my high risk regard for that joke.  
Aaron ([01:57](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Right. Yeah. Yeah. Well, that's the, you know, that's the whole goal of the joke is, is for the groan, the goff, the or the eye roll. The best is the eye roll.  
Tyler Welton ([02:09](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

It's a high respect \<laugh\>. It's very nice intro though. Thank you.  
Aaron ([02:14](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Well, to get back on topic, you know, one of the things that I thought was interesting after we talked yes. What was it, two days ago? Mm-Hmm \<affirmative\>. I saw in the SC times there was actually an article about open source security, and I thought that was, that was kind of interesting that you know, we're, we're on point with this. Yes. and that's, it's the on the forefront of, of the press. So what can you tell us about what a supply chain attack actually is?  
Tyler Welton ([02:47](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Yeah, I mean, you know, my focus has been a lot around specifically software supply chain, right? And software development life cycle, and what it means to attack the software development lifecycle. And then watching as real, real threats have sort of evolved and adapted their techniques against that. Supply chain more generally is really, you know, attacking any component of a supply chain, whether that's a physical supply chain or a software or supply chain in our case, right? We're talking about all the components and the entire process from code sitting on a developer's machine to being built, having third party libraries compiled and, and to build in some sort of artifact that then goes and runs in a production environment, potentially, you know, touching data dealing with encryption keys and all the things that a software does. So it's really the software supply chain is specifically what I'm talking about, and we can dive into any part of that. But, you know, the software development life cycle is the target.  
Aaron ([03:55](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

So basically anything in that development process that could get injected into your application on purpose, like as, as part of your build process and, and getting it out the door?  
Tyler Welton ([04:08](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Yeah, absolutely. Any, anything that could get injected into the software. And then there's, there's layers to it. So the software itself could be the target where I want to affect the software in some way. But then a lot of the work that I did around the CICD systems, and you mentioned the, the oasp top 10, which is it's a open web application security project. They kind of drive the standards around web security, web app security. And a lot of the work I did around that was actually attacking the software supply chain itself. So using the tools in the supply chain that we use to build systems and targeting those and leveraging those against companies that are using them.  
Aaron ([04:55](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Yeah. So what are, what are some of the, like, what would one of these attacks kind of look like? Like how would you know that you're, you're being a victim of one of these types of attacks?  
Tyler Welton ([05:12](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Yeah, that's a great question. I think there are some standards, you know, hopefully the worst case scenario is you figure it out as it's happening or after it's happening, right? That's, that's, you're a victim at that point. And that might be through signs of data, exfiltration, large amounts of data leaving your environment, right? And, but what's difficult, right, is that the tooling really, it's exploiting flaws in the tooling that otherwise don't have security monitoring in place for them. I'll give you an example and, and they're getting better at this, but a, one of the areas of focus that I really dove into and, and helped develop was what's called poison pipeline execution. That was the style I spent a lot of time on, and then that made it into the, the OAS top 10 CICD list. But what that is, is using change requests as a means of entry, right?  
Tyler Welton ([06:07](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Into software. So I would open malicious prs. Now, I was doing this as a, as a white hat tester, right? For research purposes. But opening a malicious PR and then knowing that that pull request would hold downstream instructions for maybe like a GitHub action or a Jenkins server to run some stuff on, and then I would leverage that, right? And the, it's one of those things not a lot of Jenkins servers had monitoring solutions on them, right? How many are really watching the traffic on their Jenkins server other than maybe, you know, making sure it doesn't get full or, or something like that. But as far as a critical piece of infrastructure, you know, detecting that to your question, it's difficult unless you're already watching the traffic on that box or on that server. If you're self-hosting it, you know, you're not really looking for, for malicious requests. And what does a malicious request even look like? So I know that's not really an answer, but to, to what do we do to, to prevent. But in that specific instance, it comes down to kind of basic monitoring of your systems and, and understanding what it's suppo, what normal behavior is supposed to look like, right?  
Aaron ([07:19](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

So if you're, if you're doing enterprise software at a company, most likely you would be internal to, to do these kinds of attacks. So this would be kind of like something that's coming from the inside, but open source, that's not the case, right? Because you've got, you've got poll requests coming in from anywhere.  
Tyler Welton ([07:41](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Exactly. I mean, that's exactly it. And imagine that you are trying to be a steward of the development world, right? And you are wanting to contribute part of what your company is building back to the open source community. I mean, how many companies are doing that? Lots, right? Netflix, how many people use Netflix utilities in their, so it's a common thing, but, and of course you want to do that first line of checks to linting checks or making sure, you know, basic tests run correctly before a human gets involved to even review this open source poll request. But a lot of times those tools are run on internal infrastructure, you know, and that's where it gets really problematic. And the systems that are pr GitHub, right? They've gotten a lot better in the, in the last two to three years about some of their controls. But a lot of times those tests were being run on internal private servers. Sometimes the same server like Jenkin servers or you know GitHub actions or, or some kind of runner, right? That had access to all sorts of stuff. And so if the attacker was able to compromise that, they now through an open source project had access to all sorts of internal infrastructure pieces, which is scary. You know,  
Aaron ([09:05](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Not as scary as the one thing you had mentioned before when we talked about this. I, I associate it with like the long con of, of taking over an o open source project. Can you you explain how that one works a little bit? Yeah.  
Tyler Welton ([09:23](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Yeah. The XE utils hack comes to mind, right? Where this library, there was a core foundational library in most Linux distributions was, was Target. And what made this one unique and really pops out to me is not just the technical hack, right? I love technical hacks. I'm a hacker. I, I, so I, I can dive deep on a lot of the tech pieces of this, but I think what's so interesting about this is the long con is the best way to say it. It took almost three years to pull off, and it started with, so it was pure social engineering. The foothold in the door was pure social engineering. It was contri. So the attacker set up a few things, and we don't know if it was one, probably a team we would suspect highly suspected it was a nation state actor, but opened a, a GitHub user, started making active legitimate requests and contributions to this open source project over a series of three years.  
Tyler Welton ([10:33](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

And as time went on, they were making and being very helpful, like legitimately contributing to this project as a means of gaining trust, right? And in an addition to that, some smaller sub-accounts were also contributing, or at least participating in the conversations. And they got, ultimately, that accumulated in this attacker getting a co-management of this open source project. They sort of convinced the owner, you know, you've been doing this a long time, right? You, you probably, I know it's hard, you know, they'd have some of these sub-accounts complaining about the response time of the maintainer. And then through that they were able to convince, hey, so and so over here, I think oh, GIA, T 75 was the username. Like they've been contributing a lot and, and have better response. Maybe it's time you maybe let them give them access to the repo and let them co maintain with you. Right? And that's what happened. And that took about three years to do. And from there, right? Then they did all the technical side, all the technical work, they implemented a backdoor, they implemented a backdoor that was dormant 90% of the time, right? And it allowed a, a backdoor with very specific encryption keys to it inter, long story short, it intercepted the way that open SSH worked and, and fully compromised this very core Linux utility. Yeah. So that's, to your point, much, much scarier \<laugh\>, right? Yeah.  
Aaron ([12:10](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

And  
Tyler Welton ([12:11](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

How do you, how do you detect that? How do you detect the free or social engineering attack, you know, \<laugh\>?  
Aaron ([12:16](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Yeah. Yeah. It's almost a distrust of everybody. \<Laugh\>. No, it's mine, mine, mine, mine. Not  
Tyler Welton ([12:23](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

To be cynical, but yeah. I mean, that's kind of what it is.  
Aaron ([12:28](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Oh. And, and, you know, and that's not, that's not the way we wanna move forward. You know, you want, especially in the open source community, you want the help from other people. Yeah. And you know, this is, this is the kind of bad apple that could, that could spoil the bunch, right? Because for sure, you know, for sure at some point that gets back to a legal personnel and a company and they're like, we, we can't use this anymore. And next thing, you know, adoptions go way down,  
Tyler Welton ([13:01](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Adoptions go way down. But also, you know, there's a few elements here. I don't imagine a world that isn't running op on open source somehow, right? Yeah. There's closed source software, but we're so we're we're too far down the path to turn back, even if that was something we wanted to do, which I don't think it is.  
Aaron ([13:22](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Yeah. I make the joke about going off the software grid and just I'm building everything myself that every way I can trust anything \<laugh\>. Yeah. Build my own os yeah. Build my own, my own languages, my own compilers. Do the whole thing.  
Tyler Welton ([13:37](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Reinvent every single wheel. Yep. Right? Yeah. Right.  
Aaron ([13:40](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

\<Laugh\>. Exactly. Yeah.  
James ([13:42](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Wow. Well, so I, I've, I've seen these things happen and I think we, we kinda shared a little funny meme that was like, you know, a bunch of building blocks and there's just like, here's everything that all of this solution stands on, and then there's like this one little block of just some dude in Oklahoma maintaining some library or whatever, like this, this is the little piece that's gonna mess you up. Now, do we see because I I I've contributed to the Apache Software Foundation, I've been, been a member of the Apache Software Foundation for many years. Are we seeing any of that, like, kind of infiltrating any of the organizations yet? Or is it more of these kind of individual maintainers? Is that where we're primarily seeing these, these sort of attacks?  
Tyler Welton ([14:21](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

You know, it's a great question. I don't really have a good answer to that without kind of going one by one, right? A lot of those core utilities for the longest time were, but you see things like the Apache Foundation, where're sort of taking, and it's not, it's centralizing control of those to some degree. Or at least providing some sort of group management. 'cause I think the worst case scenario is that there's a, and you always, when you're doing like contingency planning for a company, right? You always have your hit hit by a bus scenario. Yeah. I think when you just take that alone into account, let alone a malicious actor or anything like that mm-hmm \<affirmative\>. If you take that into account and say, wow, how many people are using basic compression on Linux? Like, it's everywhere, right? To have that functionality depending on a, a guy or a gal somewhere that's, you know, that alone is a problem.  
Tyler Welton ([15:16](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

So I think just more eyes, right? But, but I think when it comes to like NPM like moving away from like Linux and more into the, the code dependency world, you are seeing some adopt, maybe adoption's a better word, right? You're seeing groups come along and watch, watch and rank. And, and that gets us a little bit closer to you know, forcing and might down rank it if there's only one contributor and the code hasn't been updated in two years, right? Mm-Hmm \<affirmative\>. That, that can affect the way that you know, its security score or its trust level or whatever. And so you are starting to see some of that. I know NPM themselves are doing that and starting to integrate a lot of that into their platform. But yeah, I still think there's a ways to go there.  
Aaron ([16:05](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Kind of need like a rotten tomatoes for software rating. Yeah, absolutely. Call rotten apples or something like that. \<Laugh\>, that's a great,  
Tyler Welton ([16:13](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

That's a great idea. And there, and there is some of that to some degree, right? Yeah. Where you kind of give it a generic ranking, how stale is it? But it's not, it's usually centralized to the platform, like NPM as an example, but they're not covering everything else. You know, it'd be great to have something that gave you a picture of the open source projects went through the top 1000\. You could always guarantee that you had an accurate picture of, you know, how long has it been since someone's even touched this code? Right?  
Aaron ([16:44](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

\<Crosstalk\> and I have seen, I have seen marketplaces on different pieces of software that use plugins and have kind of an open API type of thing where they allow, you know, external third party development for plugins have like rating systems in their, their marketplace for types of things and like metrics on last update and, and things of that nature. So that when you are looking through like a long list of like plugins that you're gonna, you know, pull into like your IDE or, or your CMS or something like that, that you can, you can see these things and go, well, it only got two stars and hasn't been touched for  
Tyler Welton ([17:28](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

It's three download  
Aaron ([17:28](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

A year and a half  
Tyler Welton ([17:29](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

\<Laugh\>.  
Aaron ([17:30](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

It's, it's on a version 0 0 1\. I don't think I want this in my system.  
Tyler Welton ([17:35](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Right, right. Yeah.  
James ([17:37](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

The one thing that's hard, like I know at Apache, one of the, one of the project health like metrics is that, you know, when's the last contribution? When was the last release? Yeah. That can be a little misleading, especially in open source depending on the, what the, the library is. But sometimes you're just done, you know, like think about like something like L pad, you know, your, your left pad of a string. There's only so many ways to skin a cat, so to speak. Right.  
Tyler Welton ([18:00](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

\<Laugh\>, that's that's true, that's true. From the security  
James ([18:03](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Downloads. Yeah. That, that helps  
Tyler Welton ([18:05](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Downloads Yeah. Usage. Has it been heavily used? Yeah. Update. Yeah. I can see how that can be misleading. It's like, especially the simpler the code mm-hmm \<affirmative\>. Yeah. If you can solve that problem elegantly, then you don't really need to go beyond it, but at the same time, right. One thing I would be concerned at with, as a security person is what dependencies is that dependency using, right? What second order dependencies is there mm-hmm \<affirmative\>. And are they stale and do they introduce vulnerabilities where maybe they weren't vulnerable the first time that code was developed? Hasn't been touched in two years, but, but some zero days have been discovered in those dependencies that it's built out of. And do those need to be, you know, reevaluated  
Aaron ([18:44](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

And, and those are horrible to define in a dependency tree, if something Oh, yeah. Picks up on a vulnerability like you, your check marks report or whatever Yeah. Says, oh, you've got, you know, this, this thing. And I'm like, I'm not bringing that in as a dependency. So that means one of my dependencies is bringing that in as a dependency or one of its dependencies is bringing as a dependency mm-hmm \<affirmative\>. So you, you have to start walking that tree all the way down to try and find which one is using the bad one, and then work it back up to find a version that does, and it, it's, it, it's a logistical nightmare. And you could spend days just trying to find, okay, where actually is this vulnerability? Because this is not a library that I'm using directly.  
Tyler Welton ([19:30](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Yeah. so we've developed the untamed security platform over the last year and, and SCA or dependency vulnerability scanning as part of that. And one of the things we're doing right now is working towards a solution. Like right now I can find all those vulnerable dependencies in your, in your tree, right? But reachability analysis is another big, big part of that. Not only are you using that third order dependency, maybe you are, maybe you aren't, maybe when it all gets said and done that that exists or doesn't, but if it does exist, are you using the vulnerable function? Because usually there's like some component of it, oh, this function in this library of this version. Okay, does that get called, is there any permutation of your application's use of that library that might result in that function being called? And if the answer is no, then it's, it's a non-issue and you've sunk a lot of time into investigating if that was an issue or not, you know? And so it's absolutely in order to really gain adoption from developers, I think with a lot of the security tooling, it's really important that we make that process a lot easier and a lot cleaner and hopefully automated. Right?  
Aaron ([20:44](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Yeah. And that's, that's the key. I mean, from the development side, the more information you have on something that gets flagged, the better because then I can go right to it and go, yeah, it's a not thing. But I love that, that usability metric. 'cause That's what's missing out on some of these things. It's like, well, yeah, if you're using it this way, that I could see that being a vulnerability, but we're not doing that, you know, we're using it for this part over here, especially in large libraries. I mean, if, if you're pulling in a large library, you are only probably using 10 to 20% of that library for what you need it for. Exactly. And then the rest is extra utilities for edge cases and things like that, and that you may not be using in your application. Mm-Hmm  
James ([21:34](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

\<Affirmative\>. Boot boot, it's kind  
Aaron ([21:36](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Of pointless to go chasing after the red herring.  
James ([21:38](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Yeah. Spring boot for instance. I mean, it's just brings in the kitchen sink for a lot of that stuff, or even make some, you know, optional. But sometimes I can still show up now and some of this, like tracking these things down, like nowadays, Tyler, it's, it's like, it's not even really optional anymore. I think there's in there like legislation and, and regulatory requirements now around like making sure you know what the heck is bake into your stuff.  
Tyler Welton ([22:03](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Yeah, absolutely. And that's, it's really interesting. So yeah, there it is being regulated now there've been, there's the framework regulation and now there's even executive orders that are out that are now it's very specific as to who, so in this case, they're very concerned about government, right? Any governments, sure. But it doesn't just mean the government developing the code. It means if you are going to be a vendor of a gov of a, a government entity or do some government project, right? You're gonna need to be able to attest to a few things. One is just, they kind of generically define secure code code. So making sure you're scanning and securing your code, that's one requirement. But the other is the other is SBOs specifically. So the software bill of materials, and it's just a list of libraries basically in components.  
Tyler Welton ([22:54](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

It can include like frameworks like, like Docker or something like that as well. But just the stuff, a list of stuff is a good way of saying it. It's a list of stuff that your software is made of, but you need to be able to attest to the, and provide it in a specific format. And so we're doing that on our platform. You can export that if you've ingested the repositories, but it's, they're gonna require that you be able to provide that as a service provider. And that's new. Yeah, it's been, it's been in talk for a while, the MIG executive order came out in 2021\. It's 14 0, 28 is the executive order \<laugh\>, where, you know, it's a big software specific one, right? Mm-Hmm \<affirmative\>. Yeah. But they're really doing it for not only government, but ai. Now they're gonna want you to show if you're building an AI system, what's in your AI system. And that, I know that's a very generic thing to say, 'cause \<laugh\>, right?  
James ([23:47](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Everything's AI these days. Yeah. It's all ai an if statement. It's, it's AI \<laugh\>.  
Tyler Welton ([23:52](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Yeah. Isn't it just a series of if statements? That's right. Correct me if I'm wrong,  
Aaron ([23:56](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

\<Laugh\>, everything boils down to, to the bit switches, right? Yeah.  
James ([24:00](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

It's automated if statement writing, I guess, or whatever. Yeah. Well, the sbo what I wanted to ask Aaron real quick, like, it's kind of easy to do. I'm, I'm a Java guy, right? So I, I think of like, you know, the using Maven and you, you can kind of get, we've been able to do the dependency tree as, as kind of Aaron was alluding to, but in a, in the modern world, everything's containerized. So I would imagine the, and I don't know a lot about the SBO M world, I know this is an area of that you're actively working in. Does the SBO have to include like, everything down into the container, like the version of xz that's in the image that you're based your stuff on, and every layer that's in there, like you, you have to have all of those things, everything baked into the SBO m  
Tyler Welton ([24:43](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Per legislation. It's not super clear on exactly what components, but typically there's, you'll have, you'll find two types of SBOs that get generated. One will get generated from a container, or it can be generated from a server image. And so you can point those at containers specifically. The most common kind is to look at a repository and generate an SBO m from the repository mm-hmm \<affirmative\>. And that will include mainly third party libraries. But, but yes, you can do it at a container level and probably should, right? Because for example, that Dels hack, that was a, that was a, I won't call it os it was a container level or OS level dependency. And so it wouldn't have been caught right in a standard sbo with a manifest. It's just like a, you know, a PIP file and a, a docker file or something like that mm-hmm \<affirmative\>. Unless it was spelled out in the docker file. But a lot of these are in the base images, right? Yeah. Yeah. Yeah. And so  
Aaron ([25:40](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

I seem to remember back, this was a while ago when legal kind of was snooping around our software that they wanted like a list of everything we were installing on the servers as well as, you know, what we were, you know, and we had to go manually do license checks on all the third party stuff that  
Tyler Welton ([26:02](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

We were, that's another thing, and  
Aaron ([26:04](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Stuff like that. Mm-Hmm \<affirmative\>. So, you know, and to make sure that we were compliant with the licensing. So there was like certain licenses we couldn't use. I don't, I remember which one. I, I remember the MIT one was okay, I think the Apache one was okay, but there was another one out there that Yeah. G  
James ([26:22](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Yeah. The GPL stuff forces you to, if you're using open source, you have to open source your stuff and provide the source to other people. Those Yeah.  
Aaron ([26:29](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

That really way, that's what it was. The GPL ones.  
James ([26:32](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

The copy Left.  
Tyler Welton ([26:32](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Yeah, the copy left. And that can be, oh, massively problematic. Mm-Hmm \<affirmative\>. And I, I'm gonna talk, I, I'll say this anecdote, and I'll probably have some of the details wrong 'cause it's sort of secondhand, but Cisco had a problem with that where they had copy left software running as in their firmware in their, some of their switches or some of their hardware, I'll say hardware, I don't know if it was switches or not. And they had to physically recall millions of dollars of switches because man, an owner of one of those copy left licenses, claimed ownership, found out they were downstream in this software and decided to take their share \<laugh\>, right? Mm-Hmm  
James ([27:15](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

\<Affirmative\>. Wasn't there an era of, I, I forget the, the group of folks that was doing it, but there was one that was like, they were buying things that had these patents and they were, and then they would just use almost like patent warfare, so to speak, right?  
Tyler Welton ([27:29](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Oh,  
James ([27:29](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Yeah. Oh yeah. Very much like you're saying. Interesting. Yeah. If that's in your software, I'm coming after you and I'm just, you know, it's almost like extortion kind, \<laugh\>  
Tyler Welton ([27:36](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

\<Laugh\>. It is. I mean, it's,  
Aaron ([27:37](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

It was general patent, wasn't it?  
James ([27:39](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

General, yeah, yeah, yeah.  
Tyler Welton ([27:40](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

\<Laugh\>. Oh, I got another groan. That was good. Yeah.  
James ([27:48](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Yeah. It was, it was, it was like this, this like technology extortion thing going on that they were, you know, real nice software package you got there. Make sure would be a shame for something to happen to it.  
Tyler Welton ([27:59](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

\<Laugh\>, it'd be a shame if you were using this for a linting library, wouldn't it? \<Laugh\>  
James ([28:04](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Shame if you didn't have a license for that. Huh?  
Aaron ([28:08](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Hope you had to open source all your stuff,  
Tyler Welton ([28:11](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

\<Laugh\>. That's right. Give away  
James ([28:13](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

All your crown jewels. You'd hate to do that  
Tyler Welton ([28:17](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

\<Laugh\>. No, man. That's exactly, that's exactly, I mean, it's ambulance chasing for software licensing, right? \<Laugh\>. Yep. Analogy.  
James ([28:24](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

I love it.  
Aaron ([28:25](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

It it, it did feel that way. It's like, oh my gosh. It's, as you can tell, I, I love our, our legal departments \<laugh\>.  
Tyler Welton ([28:35](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Well, it's one of those things, like, you don't, you want it when you need it. Yeah.  
James ([28:40](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

You don't appreciate 'em until you need them.  
Tyler Welton ([28:42](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Yeah, exactly. Mm-Hmm \<affirmative\>. And I find them coming up most often, right? That kind of check, having that check baked into your software development, man, it's a, it's a, especially around acquisitions, right? That's my experience. I'm sure it happens other times, but it always seems in mergers and acquisitions or adoption of new tech, right? That's when it comes up is what's in here or what are we buying? And you don't want any surprises. So it is important.  
Aaron ([29:11](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Yeah. Especially if you're in involved with the DOJ, you know, it's, it's they, they take a hard look at what you're doing and will say, you've gotta make part, this has to, you're getting too much competitive advantage in this one area, so you gotta, you know, make something available there. Yeah. And, and that can be, that, can I, I've seen it kill a major merger because there was, like, we have, we, the way we have it ingrained in our systems, we cannot figure out how to make this available to the, for public consumption that won't give away our trade secrets.  
Tyler Welton ([29:53](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Yeah, absolutely. And that's a, that's a thing to keep in mind, right? Yep. Especially if you're super dependent on your intellectual property as a business, right? Mm-Hmm \<affirmative\>. Some, some IP exists, some doesn't. Not all the software developed is intellectual property per se, but yeah, it's super cr super crucial.  
James ([30:15](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Yeah. That's an interesting, like, you think about, and, and I'm somewhat new to this world myself, but like, when, if you're, you know, looking to sell a company or whatever, all the different things, as Aaron's saying that they, they investigate like all the aspects that they think about whether or not you would be a desirable acquisition or not, with everyone kind of waking up and realizing, oh, I'm a tech company that, and my dog is sizing this for me, \<laugh\> and everybody's saying, you know, I'm a tech company now. That's gotta be a big part of this, this picture going forward in the future is like, can you, the provenance, so to speak, of your, of your code and your, your intellectual property, did, did you actually come by this legally? And is everything Yeah. Legit. Now that's, that's, that's a fascinating topic.  
Tyler Welton ([30:56](https://www.temi.com/editor/t/Ji7_LzypLZjefGYa61TI1lFUM5HOFYqp80G2aGFjiRDgTk16JF--MbCFWT9q37tUltkBg6uoCnuuO7kBWOSKFBJljuE?loadFrom=DocumentDeeplink)):

Well, well we could even dive into the Providence discussion. Okay. Right. Which is there's, we and I, we can go down here as far as we want to, but the idea of providence of your supply chain is a thing, and there are standards in.

   
