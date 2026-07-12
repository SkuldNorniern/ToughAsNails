# Local dependency jars

GlitchCore and SereneSeasons are normally resolved from JitPack
(`com.github.glitchfiend:...`). On this machine/network, JitPack returns
`401 Unauthorized` for every version of those artifacts (old and new alike),
even though the identical config succeeds on Glitchfiend's own CI. Until
that's sorted out, these jars are pulled directly from Modrinth's public CDN
instead and referenced as local file dependencies from the loader
`build.gradle`s (and `common/build.gradle`, which uses the fabric jars as a
compile-time stand-in since no separate "common" artifact is published
anywhere).

| File | Source |
| --- | --- |
| `GlitchCore-{forge,neoforge,fabric}-26.2.0.0.0.jar` | https://modrinth.com/mod/glitchcore/version/26.2.0.0.0 |
| `SereneSeasons-{forge,neoforge,fabric}-26.1.2.0.4.jar` | https://modrinth.com/mod/serene-seasons/version/26.1.2.0.4 |

Once JitPack resolves normally again (or Glitchfiend cuts a proper tagged
26.2 release of SereneSeasons), switch the `implementation files(...)` /
`compileOnly files(...)` lines back to the `com.github.glitchfiend:...`
Maven coordinates and delete this directory.
