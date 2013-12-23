library(ggplot2);
library(scales);

# threads, org.sample.ForIncrement.plain_local, org.sample.ForIncrement.plain_local:error, org.sample.ForIncrement.plain_shared, org.sample.ForIncrement.plain_shared:error, org.sample.ForIncrement.volatile_local, org.sample.ForIncrement.volatile_local:error, org.sample.ForIncrement.volatile_shared, org.sample.ForIncrement.volatile_shared:error, 

#org.sample.IndiIncrement.plain_local, org.sample.IndiIncrement.plain_local:error, org.sample.IndiIncrement.plain_shared, org.sample.IndiIncrement.plain_shared:error, org.sample.IndiIncrement.volatile_local, org.sample.IndiIncrement.volatile_local:error, org.sample.IndiIncrement.volatile_shared, org.sample.IndiIncrement.volatile_shared:error, 

#org.sample.PingPong.pingpong_plain, org.sample.PingPong.pingpong_plain:error, org.sample.PingPong.pingpong_volatile, org.sample.PingPong.pingpong_volatile:error,

a = read.csv("./jmm.csv", header = FALSE);

a;

forD = data.frame(
    threads = a$V1,
    plain_local = a$V2,
    plain_local_err = a$V3,
    plain_shared = a$V4,
    plain_shared_err = a$V5,
    volatile_local = a$V6,
    volatile_local_err = a$V7,
    volatile_shared = a$V8,
    volatile_shared_err = a$V9
);


indiD = data.frame(
    threads = a$V1,
    plain_local = a$V10,
    plain_local_err = a$V11,
    plain_shared = a$V12,
    plain_shared_err = a$V13,
    volatile_local = a$V14,
    volatile_local_err = a$V15,
    volatile_shared = a$V16,
    volatile_shared_err = a$V17
);

ppD = data.frame(
    threads = a$V1,
    plain = a$V18,
    plain_err = a$V19,
    volatile = a$V20,
    volatile_err = a$V21
);

forD;

labels = c(
	"plain_local",
	"plain_shared",
	"volatile_local",
	"volatile_shared"
);

colors = c(
	"plain_local" = "#00FF00",
	"plain_shared" = "#0000FF",
	"volatile_local" = "#FFFF00",
	"volatile_shared" = "#FF0000"
);

hLabels = c(
	"plain_local" = "Plain (local)",
	"plain_shared" = "Plain (shared)",
	"volatile_local" = "Volatile (local)",
        "volatile_shared" = "Volatile (shared)"
);

postscript(file="for-loop.eps", onefile=FALSE, horizontal=FALSE, paper = "special", width = 12, height = 5)

ggplot() + 
 layer(data = forD, mapping = aes(x = threads, y = plain_local,  color="plain_local"), geom="line", geom_params=list(size=2)) +
 layer(data = forD, mapping = aes(x = threads, y = plain_shared, color="plain_shared"), geom="line", geom_params=list(size=2)) +
 layer(data = forD, mapping = aes(x = threads, y = plain_local, ymin = plain_local - plain_local_err, ymax = plain_local + plain_local_err, color="plain_local"), geom="errorbar") + 
 layer(data = forD, mapping = aes(x = threads, y = plain_shared, ymin = plain_shared - plain_shared_err, ymax = plain_shared + plain_shared_err, color="plain_shared"), geom="errorbar") +
 layer(data = forD, mapping = aes(x = threads, y = volatile_local,  color="volatile_local"), geom="line", geom_params=list(size=2)) +
 layer(data = forD, mapping = aes(x = threads, y = volatile_shared, color="volatile_shared"), geom="line", geom_params=list(size=2)) +
 layer(data = forD, mapping = aes(x = threads, y = volatile_local, ymin = volatile_local - volatile_local_err, ymax = volatile_local + volatile_local_err, color="volatile_local"), geom="errorbar") + 
 layer(data = forD, mapping = aes(x = threads, y = volatile_shared, ymin = volatile_shared - volatile_shared_err, ymax = volatile_shared + volatile_shared_err, color="volatile_shared"), geom="errorbar") +
 scale_x_continuous() +
 scale_y_log10(limits = c(10, 10000), breaks=c(1, 10, 100, 1000, 10000), labels = trans_format('log10', math_format(10^.x))) + 
 scale_colour_manual("", breaks = labels, labels = hLabels, values = colors) +
 labs(x = "threads", y = "operations/usec") +
 theme(axis.text.x = element_text(colour="grey20",size=16,face="plain"),
       axis.text.y = element_text(colour="grey20",size=16,face="plain"),
       axis.title.x = element_text(colour="grey20",size=16,face="plain"),
       axis.title.y = element_text(colour="grey20",size=16,face="plain"),
       legend.text = element_text(colour="grey20",size=16,face="plain"),
       title       = element_text(colour="grey20",size=16,face="plain")
       ) + 
 opts(legend.position = "bottom", legend.direction="horizontal", title = "Summing up the field in for-loop")

postscript(file="indi-loop.eps", onefile=FALSE, horizontal=FALSE, paper = "special", width = 12, height = 5)


ggplot() + 
 layer(data = indiD, mapping = aes(x = threads, y = plain_local,  color="plain_local"), geom="line", geom_params=list(size=2)) +
 layer(data = indiD, mapping = aes(x = threads, y = plain_shared, color="plain_shared"), geom="line", geom_params=list(size=2)) +
 layer(data = indiD, mapping = aes(x = threads, y = plain_local, ymin = plain_local - plain_local_err, ymax = plain_local + plain_local_err, color="plain_local"), geom="errorbar") + 
 layer(data = indiD, mapping = aes(x = threads, y = plain_shared, ymin = plain_shared - plain_shared_err, ymax = plain_shared + plain_shared_err, color="plain_shared"), geom="errorbar") +
 layer(data = indiD, mapping = aes(x = threads, y = volatile_local,  color="volatile_local"), geom="line", geom_params=list(size=2)) +
 layer(data = indiD, mapping = aes(x = threads, y = volatile_shared, color="volatile_shared"), geom="line", geom_params=list(size=2)) +
 layer(data = indiD, mapping = aes(x = threads, y = volatile_local, ymin = volatile_local - volatile_local_err, ymax = volatile_local + volatile_local_err, color="volatile_local"), geom="errorbar") + 
 layer(data = indiD, mapping = aes(x = threads, y = volatile_shared, ymin = volatile_shared - volatile_shared_err, ymax = volatile_shared + volatile_shared_err, color="volatile_shared"), geom="errorbar") +
 scale_x_continuous() +
 scale_y_log10(limits = c(10, 100000), breaks=c(1, 10, 100, 1000, 10000, 100000), labels = trans_format('log10', math_format(10^.x))) + 
 scale_colour_manual("", breaks = labels, labels = hLabels, values = colors) +
 labs(x = "threads", y = "operations/usec") +
 theme(axis.text.x = element_text(colour="grey20",size=16,face="plain"),
       axis.text.y = element_text(colour="grey20",size=16,face="plain"),
       axis.title.x = element_text(colour="grey20",size=16,face="plain"),
       axis.title.y = element_text(colour="grey20",size=16,face="plain"),
       legend.text = element_text(colour="grey20",size=16,face="plain"),
       title       = element_text(colour="grey20",size=16,face="plain")
       ) + 
 opts(legend.position = "bottom", legend.direction="horizontal", title = "Incrementing the field continuously")

postscript(file="ping-pong.eps", onefile=FALSE, horizontal=FALSE, paper = "special", width = 12, height = 5)

ggplot() + 
 layer(data = ppD, mapping = aes(x = threads, y = plain,  color="plain_shared"), geom="line", geom_params=list(size=2)) +
 layer(data = ppD, mapping = aes(x = threads, y = plain, ymin = plain - plain_err, ymax = plain + plain_err, color="plain_shared"), geom="errorbar") + 
 layer(data = ppD, mapping = aes(x = threads, y = volatile,  color="volatile_shared"), geom="line", geom_params=list(size=2)) +
 layer(data = ppD, mapping = aes(x = threads, y = volatile, ymin = volatile - volatile_err, ymax = volatile + volatile_err, color="volatile_shared"), geom="errorbar") + 
 scale_x_continuous() +
 scale_y_log10(limits = c(10, 1000), breaks=c(1, 10, 100, 1000), labels = trans_format('log10', math_format(10^.x))) + 
 scale_colour_manual("", breaks = labels, labels = hLabels, values = colors) +
 labs(x = "threads", y = "operations/usec") +
 theme(axis.text.x = element_text(colour="grey20",size=16,face="plain"),
       axis.text.y = element_text(colour="grey20",size=16,face="plain"),
       axis.title.x = element_text(colour="grey20",size=16,face="plain"),
       axis.title.y = element_text(colour="grey20",size=16,face="plain"),
       legend.text = element_text(colour="grey20",size=16,face="plain"),
       title       = element_text(colour="grey20",size=16,face="plain")
       ) + 
 opts(legend.position = "bottom", legend.direction="horizontal", title = "Ping-pong on the field")


