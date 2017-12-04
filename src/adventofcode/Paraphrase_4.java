package adventofcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Why Did you create this class? what does it do?
 */
public class Paraphrase_4 {
    public static void main(String[] args) {
        String s = "una bokpr ftz ryw nau yknf fguaczl anu\n" +
                   "tvay wvco bcoblpt fwzg sfsys zvuqll mcbhwz ovcw fgdy\n" +
                   "ynsocz vid rfmsy essqt fpbjvvq sldje qfpvjvb\n" +
                   "yvh nxc kla vhy vkbq cxfzgr\n" +
                   "kljv ymobo jlvk ebst cse cmlub tavputz omoby psif\n" +
                   "ebfuvvu paqgzri uvvubef hglk jvn gzeln bdl ziqgpra bzcfa\n" +
                   "tclq ytw tclq tezcqys\n" +
                   "qae eofr yzwcwqf wqm ytcdnc pxnmkw\n" +
                   "krryi irykr ycp lbeed ykrir lhq rdd tyujwd\n" +
                   "hms pii lxoa dchsvz bepjwst bllxkqg hsm yrdj myzvju msh lwnnc\n" +
                   "yxqh hqxy xkn ljjsqjh jjljshq\n" +
                   "mhgsehj urbvnvf gbz ykxsd hsmgehj wtoc ujpfaos eir vifog tsy kdo\n" +
                   "wfruf wwijme pxbbsvf asmgs ccbn vwtc mkhah oxxfh\n" +
                   "lxqy jzvcvd cfgg uahxrwr dqmaqr bwzm wruxhra lrb lmk\n" +
                   "jspgxo yuhgni njzqtn zglkzz ybc itj orqr zgqwuoo mjagh erll srqrk\n" +
                   "cbrtnbx ukblei ienmdm sinzq lytyliz mma lizylty zeumwgu\n" +
                   "aeggz eljcry buqdeog dvjzn ilvw arz vep kxdzm mvh szkf\n" +
                   "imn sfty ugg flqq nydky mni bkqzlok wye lehwlmp xeyfmj\n" +
                   "beyv oamrpkc tebdkwv zlq jes mqvif sej qpsnmjz edvtbkw\n" +
                   "hylmacl wwlra xntnvg ppvb bzof cymllha\n" +
                   "qktxomf ngfpuz qqz malc zxuqz szg zis vzro rfpgk\n" +
                   "phru sxlg qzqlw uej vmd omzga jue\n" +
                   "drzgojf ttqdqar weikik wvrjtxi gbj jramqh nlwoj drzgojf bgabmn xqlaeun\n" +
                   "aiuohu pca apkmv cpa kmvpa nmdn\n" +
                   "gelymv eto itcnuhn ote teo\n" +
                   "oxiz xzio kqu wwgow\n" +
                   "picoyb coibpy acsw ehlirq deyz gymqvz opicyb vuet lrl\n" +
                   "zerg rezg miwtjgw gezr cui\n" +
                   "mlh qlu ktil tnlgnrk bfqbk pgg qxeyd noadmjo nonlsh eqxdy\n" +
                   "yqqaq yqqqa xod oss\n" +
                   "mkotw bznvs xowoofq sebp wsgpsmn fytcpc vvmzr vmzrv xwtxz zrvvm\n" +
                   "dvs twhz teqmlow oqg sjetxd aku cwl qfvrkex mndsio hfg\n" +
                   "itdl qwdagkk wli tdil vlgur dyl xvfm\n" +
                   "wlmyd dwmlx zhmqd zqmhd edzsvmz yclg umpq\n" +
                   "petva gazw byrca pvaet epkoqh nlp vqfl vatpe\n" +
                   "rykn ckr dijkme kmiedj ozlh deikmj\n" +
                   "kuecjh sfqv pojfzf fjopzf fjpfzo amxtc\n" +
                   "hri gglmial lrwbyc memgszu hir cfwlg ylcrwb\n" +
                   "rxrfbtv pwpra fngt auh rapwp zrruuq uah\n" +
                   "cevc utfd ysrfcw nnlg fnqtx aua htteunu mrjhhj\n" +
                   "tvnxznj mvpagt nqmxvnl mutn ntmu eybh vkqeaj frayclp\n" +
                   "ygktzxo lzwwy qsipu nwb jdmw pahao paow mwjd uivqbnj woap nyyogcc\n" +
                   "log zihz rsmx ixfr xwvd osg zxc gol ufnbig\n" +
                   "dogve cnb osa xbafl vefr nxlw yjgquui\n" +
                   "ucyl aaoae ktjvi fyps xvjhpbh iiur tuc\n" +
                   "pqt jasxg ehhs lzjzzzl sqmmj vwyva eklbtv hksanb fuesnd oyw fuesdn\n" +
                   "uankv wesi frhpau qiucu lim uzbdapf ciwjd tifbqxh tfbtsdi\n" +
                   "vgjd izpofu fqjpcct phuz\n" +
                   "cfg cfg rgahl frm emn pbfsmgy frm jemwqgn sfpm azunntj igl\n" +
                   "daps hpe fqg err sapd dci vbzlqx gsigq eyp rre\n" +
                   "iuqyqdy djprdj mgtkdxr pwmkzv wmkvzp hppisd pidphs\n" +
                   "rlr rrl vhevh cucprc xki urte lrr zfc xrqydzk ipjkyxj kytul\n" +
                   "jwbkaee rgyjl rjljbwe ppq plp pfts ijd ckpvmw mbdrqh zolt lzmr\n" +
                   "alw law awl wknavtb esklsbj wvssyai\n" +
                   "aqy ldf qdht soxkg qtfipe nsdm aqe rtlc fbqrk ius gybbhxr\n" +
                   "xteov wgqoqim nlz szlj oxevt xwb\n" +
                   "tmgdst fyn oul tsohzbq ltmxji fgops gatssx zxdzfc talb\n" +
                   "zkvjpu jnhtc nxs jqv pyoqz zsj ckwd xot ykai\n" +
                   "fxfarre yjbxvj lqfaglo mbxuv bmuxv bxumv\n" +
                   "yrhi uosldj hryi fwres ycygw ycvxze zevxyc iyk\n" +
                   "yphev xisbai xdb hzrbg ayxbhdx qnvbus pwc\n" +
                   "wytqraw yvurj erqckl rvrvda xsh gsd bxtm acxle gpndk\n" +
                   "kpvjtu vacggk oabcuoq qusf zitqpgn pbyq ocabouq ntpgizq gaiiry dke\n" +
                   "frz ceozajo ljltawq tjepzp iflv\n" +
                   "zntejm dkfgc ysno noys sony muy\n" +
                   "qdnyvvw oykq bnmldt zjgauw pviurd cbcnl tnkhq ebsey bccln arvwe\n" +
                   "iqazt xidjgom wcrdz itht lfh ifzwkj rwqxhy ervcgmt vojg lzntz ezg\n" +
                   "tlcxioh qvvkan wpi ody\n" +
                   "mhsy dwm hyms yegvvc\n" +
                   "hbkvi wvemc uwxgqf pwrgu wcy wxqfgu qkzppc vxcwdwd rcgp ivjd wmevc\n" +
                   "upc ucp cpu unmr pyod\n" +
                   "bqfew ebwfq paccwh phgc fchhr jrnio\n" +
                   "abh bjalls bdtac zzvt totdlc yptqmgu rpcin bch cqklqly\n" +
                   "bsnss qcsgi tegyz lqoqkpf qvatlyu ibza mzfotsk lye oqqf mnor\n" +
                   "lzrxca stkbn axhr wckbip bsntk ahrx\n" +
                   "oricdw cnpte dbz nqx xloxc bdz fdsl uyvgi nvoy ezbi\n" +
                   "nlcqye ofta jcvqvtg yxduyh btawc tjgvqvc tcvqjvg\n" +
                   "nji znctdfm kkmp pmt ikhl jjoubc xnp zdctnmf covvmsh ydh ircplcm\n" +
                   "yafkuk yasqsyt ytqayss nusgb ukfyka\n" +
                   "yogcf emg jlkd blupemf axg wihhrb ysernt yznhz\n" +
                   "gmc yyqtgp use lohoit\n" +
                   "lclwa ojjkm rxr rrx\n" +
                   "punyfv iphw ddbc jghx lrssszc bepexv sicpy syicp lszrscs vrqjb\n" +
                   "rjanra juh hljdmad scu usc baifu ijs suc bgdbbv\n" +
                   "ogs hehi lgiwowc wwezznc ogs lorcl naunpll wlmal ajcbj ciujw\n" +
                   "slenm xxod vhf amhts\n" +
                   "mrrduda mrrduda lwecwjv lwecwjv vvzmjla cjipv\n" +
                   "ixnv invx inmzz aoxghpv\n" +
                   "ulyvfrf zsup zfryjy xoo agdsd giw papa ljtu rzbjiq wrex\n" +
                   "bzpv svpuyov mklrct uzox\n" +
                   "fxs iypd uaqch kxazj ksjyv\n" +
                   "uxaommf xtq uubbfk bmlq kdhgjzg oxwpag itfij irmkjx ggod sddcyo bopn\n" +
                   "lch plmvfni qbjr dnu zjcod qlwax gejmyj gxjqm mfzkb gejmyj\n" +
                   "yoa thrfbto wposvrm amulogu mcqzfax fjquli oay\n" +
                   "kywj kqqhney ozuljxz wqwfte ubo mjj anhhg aphy ocfnef yhin ywnx\n" +
                   "vxuledm wllj obqtsrr jwll uvmelxd xvj gbwte\n" +
                   "hevc bitwu ydw ywd btiwu iuether gfe\n" +
                   "dzn ssmfpel wbbdeyt xge hrfi\n" +
                   "zebz ifhq euto ppfnrwc winkkj\n" +
                   "utuly wtdt iahpe ihtxwmh zxun bqluj hsaxgcs ytluu jlfnnuv drxlctr myhp\n" +
                   "kwxgy hreul rsnh wdmsx kkajywb\n" +
                   "bond djq kccazc zvzcie hndm myx cmhyhkc ove ord dqj\n" +
                   "zcong tekgn pbzs ywqgqgu eizrx ypydeku yqyjdjp dwsu zxire zcgon iggnvf\n" +
                   "tkioh hflkm fsjz gisjbi otikh\n" +
                   "ccdqqm fdabbne fyd lbyqm cyzgtd puitvjz nluf hirrpxd tgxrg vvl\n" +
                   "hjnygbz fnu twwbp xqw pfdlt uoalyme rsd muayeol ezcq\n" +
                   "kubeooi bxgwoun paogjs twvwlji opsajg higbdfi aazo evmj\n" +
                   "sfipxe mqbkmrn plwqd zvq nmvom fyfbs nbs qkrbmmn eym kqnrmbm\n" +
                   "ruhsp hurps mqws umm sphru\n" +
                   "ksjs pgpxh qozg enplxbn oqzg rvjnaje sjsk\n" +
                   "rbwbvog mhgtgg uld twrqz rbf kpop\n" +
                   "lwho lohw ylhd dej lydh vsfffsm\n" +
                   "icljgu gluijc vthqx orynv xhvqt\n" +
                   "biav elxkct mtaw nlafk snyr cbqdwim blim rtrqmc wze cxktel\n" +
                   "fgpeia ebkhga azlfsr bsj pipvwsd nry bayrjzl ftth ynr mfhd\n" +
                   "ymlowur nighqgk yjv pyxf nan xamb ohm jvy owrxbg icbz\n" +
                   "iyyt linaqu httt zyfeo udap mllq pdxo lpl djhqaou zkit llp\n" +
                   "dxspk yge kcqjqpz ulb hoe mfx nwayo\n" +
                   "rdnmmh gyqd qhxrzj dgizu lyittbv txngpdg fiu mwd ndp oks vxnxybi\n" +
                   "eul ztpe evnz yxx iuwon rkbbsw liy mqhxt\n" +
                   "qahp zwn ualtk txbt cbthj xchqy pirucp povdwq\n" +
                   "mqwu mwww muiafa miaafu hzripx wmww\n" +
                   "auw hyyi ylewfi ihva jknbrry voxzooq xaos xymv qzzjw hjc\n" +
                   "enpb jqa ajciy cbeopfs tqrlqj ecudb gso cyjai gxoet\n" +
                   "yohkjj yohjjk xapawgo rtgnjj\n" +
                   "lnlxxn nxllnx vhjrev uoew zts smkd kynlrg\n" +
                   "bkblpr vgafcy alju aiyqe eebtsyu buve hdesodl pspbohw\n" +
                   "aacmw qpndwo tcwsfqy qecnms wondpq sto\n" +
                   "wdsyxe edsxyw jnzruiw pfqdrhi\n" +
                   "pfgxekl vswgxhb qyn mykn jimiatq zkcz jimiatq kaexgxm mykn\n" +
                   "xegwn upudt dew uqjrcl abyof hbtiko wxgne sorgno etm\n" +
                   "xzojs zxsjo szjox gumjtwi\n" +
                   "gttngkk bwdgce bhuw fgo rcbf byw\n" +
                   "ngtzwqx ptx xodmy ctmtf oioahmm qajlhje jzilpk cvypp ijaefz\n" +
                   "arlx slcugvm hyuo zoptsh emyr tndx rroecp tdnx xea rtkpd\n" +
                   "sfckdx ktyrjju ruwjtp zhqznj vncun\n" +
                   "oqqh xpc itrdg gtrid hoqq tuo yijh ncp suvck jic\n" +
                   "brrlqu twdt urblrq twtd\n" +
                   "brfuh arwtkpu mzlj wdyqk\n" +
                   "pmag dtwnva nect azld axqrwy apgm xbv gdq ienubsy andvwt\n" +
                   "hqb qbh gxdl mwjn cmfsmik\n" +
                   "yiwma utlor qxjfjsn aomlvu gxp ryj rfkdsw kuguhyi qxxpg\n" +
                   "ifq wcvcgly jdalgzx lgcycwv rajmnqw\n" +
                   "latakk yxxbw evy vey\n" +
                   "odkvw ojgveb jhg qwhkyoh btvu qbfot nouv owgtsi pdwbmfn pmvcv dnqbo\n" +
                   "tmka qqnty knz swi fyvmt ikcdu jfjzsfu dshgi cosacuj szjjuff\n" +
                   "eanet uua fbztk bzkft\n" +
                   "jepi hyo jgzplr jyqk zzcs iepj hfamvu bfgbz sjsnf lprgzj\n" +
                   "mlca ywko mtg vkfv ojka zbelq qkaujs simt kafq qtycfzo\n" +
                   "sqh omv llvra ecvxmtx dpnafv llvszx xzlsvl quj ufnhvod faraf fivmnl\n" +
                   "pvxlls fzeoav ahgv uhq nodcr cohy vqisgaj jsfcyur dbohh\n" +
                   "ztccbwk okv vok kov ywel\n" +
                   "xyu cmaikc jgqu ozccdzk ybn yoeq fky aetrkj eyoyvla laiu cermo\n" +
                   "sssnb kxly mgvaz jpffkq bysbwwu rfnkm eycp ipyd hyi wjew\n" +
                   "obdfqmh flkm semednj iafewg lvh uwa ciepe\n" +
                   "zmldp ykffe gtehz qlmvule edrtzg prund oagwto qia bvyxur\n" +
                   "kjok neno qbxh wqgkkt ympclso poyclsm cajgnnn\n" +
                   "paqili kur sfit jbqchzx bhjqzxc\n" +
                   "fhghm ubtaana qbn autnaab aaaunbt vmz\n" +
                   "exlrl hfnpq zgdwx smix nyg ogccrhj iimhhwc uhcldo oydwxp kqc jxxpycv\n" +
                   "wtdqjfh ialoqr zeej ipoh qtjdwhf wdhqftj\n" +
                   "jcgug cmtvmu ynhnilj txlv uemowyu cvrool oolcvr njr cxqntdh\n" +
                   "uhtwtp tgnc jmmjl utiu jfxtsoz cxwqcz\n" +
                   "qntxl lyownp tsp tps mixyge rqfqumc bxjiry zmaj azjm\n" +
                   "abt bat tftvm nyjs jyns\n" +
                   "hzsdh pwthfvm cedg hzsdh rsxtehn owh cedg\n" +
                   "hcoiny aqbeme eeuigt pocpvox tiugee rwb tvgmyc ojg hgdaf\n" +
                   "mzlwcfc uoobo bouoo tvgvmiu evsfkm popgm evmfsk ehxvits vebxbmd qhmz jzj\n" +
                   "mypgg jbpx vgeb ahvjl zbm ancdzfy wytkcq\n" +
                   "bivscw zmzmjxu jzm fwb ujefxp jzsiskp cgx atcj sszikjp cxg nqvxga\n" +
                   "vvurbxp iry zlz gfnlpuy npyugfl\n" +
                   "fpmee mhj iul lui liu\n" +
                   "xjoesn ggsdc vnisnmw kyxmmv xphfq\n" +
                   "zcsml ngzlpy udaoab eotbv ylca bfmums izx\n" +
                   "pdi bpyoep cofsy qazl oaovek fvfbe sotc lfdmaea smvs\n" +
                   "zajm bskaqhj qxyiptb bdyeuqr dqjrekn iywj\n" +
                   "hzhky hukvpve iqcbwju nyiwb rvutxlb hyuah urnhxg savicaw hexr ptedk\n" +
                   "qndji wrr sin ljogf ncrb zvt tvz\n" +
                   "kvfke tjpzhrl zvd doq kxyw fdgr oqd egkybdh rqpfxks nja\n" +
                   "escstpv ccc ryzdv gxkjuyt gkhw jxnfda awpzg csestpv\n" +
                   "cpcd onxeae nimbrpt zyji qnuo ktxgwbj vtjfglz skcozd zgii zgii nimbrpt\n" +
                   "lwq iue hfbv hgbg aeqc\n" +
                   "vzgbod yjkoc ckt bpiaz\n" +
                   "eyco ecoy uzousjp faxj utu yoec\n" +
                   "fhqdi myd tvex bzizkcx pifcfhz fczhpif eofzv bqzd knbhbgj dok ffcizhp\n" +
                   "qlqlgmz hofmnc cwtk ahgnpne acn prwdh hwdrp rfofhl atavrf afkcbk\n" +
                   "sgl apyfr pwxzptv osuwy vmqqh soyuw lqilked oinhh\n" +
                   "eglqdox gcxfxql ejtnwu wvho can eyu uetwnj elgdxqo atvpkk eailsnn cwosyn\n" +
                   "mylxhuj kbc apnllw qbmtj sqy hxtnvoe ins iyudo aagezrq nsi ikvn\n" +
                   "lpmzo tkdeg zilkm vdkmtf yulbdd dkfmtv\n" +
                   "fzrv grq zfvr ychga gqr\n" +
                   "vdjxx wew pdxgp cjywsc meoffrj pgpdx chxmw eizgz ruea\n" +
                   "iaklyhx btqqik tbiqqk ynmq laxykhi qatrnsh lnmtm plz\n" +
                   "sfogup jtdsx tsxjd wwzkyy wzywky vgdsgr\n" +
                   "paupqb kyy bccklmr vopviup lctcxza yyk yky\n" +
                   "gduuia doek hqcr upvb szeewnu rrrdz\n" +
                   "lhnsaf lut kzf allu dvj tyngx zkf aqsgz rtkzzdz\n" +
                   "xxqj msg xxqj ezmm tmyji msg cco tain ctpel\n" +
                   "pvcfzv rhn hlhxyu bghzzpx dlhvr hrvdl lhuxhy\n" +
                   "npzhkp voghdv rvezqff hvgvdo jndf gpa wevrwpu\n" +
                   "faixq aecax hxdouer yqlngzd grf wid iwd cce xnmmr\n" +
                   "ifqwiah dib ibd dtvkwqj mpn dtwjkqv kyntq xwlv\n" +
                   "rwoiz dja cvv lvza kfdblq bgtwgh ongdub wggthb lvaz\n" +
                   "xajf eyasx rupsyqx wubjwx bsrqi ripghci sbzxp sbz dhooax\n" +
                   "ydnv tvhwgp uvrh yryhl yxdlwa ladwxy awi mkwyn ghvpwt\n" +
                   "qrl vwdvwic ocbhpi bcmz dor lrq hokg gokh\n" +
                   "adz echnlju ebnmw twjl cfw loq fqklyyq clgqq jtgpsu wltj\n" +
                   "vwlgisb murtsw ldkacqv wxfcke vcqkald ldhh gsl kpzn\n" +
                   "itnvo lyddd saewfse spnri vtmst iblx\n" +
                   "qsgv qni wvqiih mneg lkpb quhbkyi\n" +
                   "efwaaa huu fslzwpc uuh szflwpc\n" +
                   "sgmj ajh vcwpcua enltaks aquooh bwoda txbuve\n" +
                   "vbe astgezx xqbxkdj evb bev yuuesdc fvohzq\n" +
                   "gpn oqxfz pbwibjw gljdbf gbldfj sis dpk iss\n" +
                   "pha ebybvye ntxhs wcuce\n" +
                   "odnnywv qpcjll aslxqjm injfs vkbturz atxi\n" +
                   "zzncfj kbhk jzzvnwf kqipx qkxpi rzb czfnzj\n" +
                   "ygu vqpnxkw trdtv rrte\n" +
                   "hrutley ljxuuq yonbpmk hmpc etyrhlu\n" +
                   "odxp fpvizzx dxop jjbr skhxq mpzawhe zptdxuu erxk adbbuk zfzipvx\n" +
                   "qjovasi yutjpg rcp bykpctm fqmmg pckbymt hqj\n" +
                   "ssqc cype tkowxb fbh rsluu zjk scrukwv pkuexk qlgjtdq oulrke\n" +
                   "bkcd nnf hdj sdlweyr uyf kmvzq\n" +
                   "sgeg moy png blv bblree ufe uqknuqd lnjwbh\n" +
                   "snpex hrbcfok pffv cwrvhcs fpk uprhn gbpy zkxyi esug ccnnj\n" +
                   "bmwue dugcrdu uifiy clid rdmodec jodp hti xptj tpopl vuwhdyi hnoq\n" +
                   "cwlkg qsz nnp lfyk pwn dpe oeuzp jusxxkq qlnchc\n" +
                   "tsmkvge pxauyc cxypua boi hybq rzf iioyi rtedkc gjmk iob mqb\n" +
                   "cvip wgbjhe ulwg jckkwd gdu bmaoisp\n" +
                   "drpl xbliszf rpld ngnvgxl xnrd xsmd oetrcmn xvfohp mtocren\n" +
                   "habmf dmfxq qitw xxtybla cxvb colcvpj sowoeuh bhmfa plccvjo naftjgw\n" +
                   "cix soo icx ahx cdrjyxe htcnp\n" +
                   "acoksaf cgahlg tdj euchwnj bdn lunouq aewrk uktre kklwqy lnouuq\n" +
                   "ibsel hwjbah vxuk bjxa dvzbpq tffqvo bjax qfoftv\n" +
                   "iynms tzv jakuuw cmz cjnyr ddibtd gcb\n" +
                   "tmgerk pvwizc lxoma ergmtk xmg loaxm\n" +
                   "ajazon yjwt viyemnk wobzwwm jcucn nopymyq znaajo qcjtmlq ccjun ywvt oqczod\n" +
                   "kdhgnv kdnvgh rpyrxx xpyrxr\n" +
                   "qftmshx hrbr kcggxw jwtuk qxbzkn\n" +
                   "ddi fjekwxs xxua cmmkrso\n" +
                   "ptrsv favvfh innnnx nninnx\n" +
                   "kzsnd pnf evtazgw wmjk gvxp bslajo\n" +
                   "nphqtka umlxu ymw whqiab whqiab vwigkz pevtps\n" +
                   "vhje cnu uzfzum rwucy mxr wyrdqfi gnkuwz dkrwc otfc vbfc\n" +
                   "ubtzio vlijsst anruj qyntadb fnic klz ywqq fnic vlijsst\n" +
                   "rprj ybyqawb tgeieih nzcr rjpr bjfpozh tpevsx flvjdq\n" +
                   "kvqqzvm cfdm wzjmkq sbcfx vzmkvqq\n" +
                   "zqtt elpg eglp uoe glep\n" +
                   "lqv madhtch xevl fal ijmx chcpra lzl afl cndbvnq\n" +
                   "yjx jyx xjy otwklfj\n" +
                   "cur egsdzaz ocbx wvky coxb pgiysbh lclhvy gfu oxbc vqyjvhh\n" +
                   "gtd pytdaz kecsku nkiud ytt bmgobx tyt pfleji ebqlifv lqp ytzadp\n" +
                   "bopfdvy eovszvw krgu jhuhyqi kaczafr krgu zlfxtl\n" +
                   "yixprs zqai oprgw vcsjoc pgorw ypx ijo urjcjqv\n" +
                   "estg oqnhw xgwajp mpbsag ibzi\n" +
                   "zggbt jmmtkru sye ybd ztggb\n" +
                   "tzryuqb blyxnnu sjpmf yxe zimf uyzqtbr qbyrtzu\n" +
                   "rzivz rxn invxqd nazw efzun bwnw ywx rfuda jhnoww mketav\n" +
                   "zxfw zcaqi qaciz ktefiwk xwzf\n" +
                   "ntougl fvyaxfr obml obml bjkm lgsqj yfcggdu rqcpgt ntougl nveto\n" +
                   "rma dakifg pvfc ticvff iffctv difkga\n" +
                   "wpnt eclov vmmoqh qvw mljlvnj hxrx\n" +
                   "ijnpo uhgxrfe xxopw xuzwyd powlpo ctduj eepw gubnepv\n" +
                   "rxcmve myxckxk ecid nxe xevrmc juzaonr ilkx zpb pbz mvgos yzr\n" +
                   "yfecm wqkh defqqa mnzgx nwe ixxg rjdhe new\n" +
                   "awztgx vqgnfd iwcakr ajaiwn jiwnaa uqfrim wrgbjon ufqrmi vdu yjwy gwkdc\n" +
                   "vrqf yzmvnr jkjji ghya pdlye ygha qlcm twmkex frqv\n" +
                   "hjb xgypw vtr mgj asa owcuks fnllp ommrhng senv iix\n" +
                   "usw iyuatv ondiwh neac ttge tzw bvjkfe neac usw\n" +
                   "qwehwhj idrwo vex zopkjd lrcc sfqyz smte qrfh lccr qwjhewh vlb\n" +
                   "efnlhsj ltm xirn nctwio cin\n" +
                   "zocc cpfo czoc oiz tftk\n" +
                   "rlzvqe inivone kptyumn eatw urjxc aetw\n" +
                   "qavvqa jvvc yux cvvj\n" +
                   "bfr fcpc xpkphcf irak bfr nuhsooj nniugf bfr gllq ipo\n" +
                   "ekd dydxs rnmgb dek yowk\n" +
                   "ipdll wdgx gjiigd uleiwg buvv vdhuzg gigidj gkyigmx lpdli lzyode fqdpvms\n" +
                   "ycna rhyz bsipz lit rmc mrofb cyan mrc wujk\n" +
                   "tjrk cwdsvf srkdjy lsyvryj nko syjvlry fgqq srdykj pgb koh dyle\n" +
                   "sflcxt wmgdgej akllaoa bbsvve nsxnt nsxnt kgm akllaoa btqbez\n" +
                   "bzmoci agemx mdtiol pyohvf zwtx aqblx oibmcz ypcmz lfg ckssn ozx\n" +
                   "cuojke joekcu eusr dxqk xxwob klpsm\n" +
                   "byspz lyunt eojrx ubh rjxoe ypzsb\n" +
                   "ibok bkrtut wzcdk ppm qekhvy aupaic vswwul lmlxrv ainigy sasurbx\n" +
                   "jeigcyc cycgjie resio ncz\n" +
                   "xvxr lmlaje ebmtn cvms xrvx vsmc\n" +
                   "cfjbffj xvo hpsbu nfm jhlsk mnf fmn\n" +
                   "xncxo iwuon voj aebv jks nynzl hwjwo womejo ugzmr tdfaep olpdiaf\n" +
                   "jlnusc hgpprf nulcjs kwiwypu kitjjbj snlcju\n" +
                   "buqzm kpuoxel ajlqke qqdur jecuibn leajqk qudrq usi\n" +
                   "ahbnjf uuzecdv yfyrsxv eoqey oonue vyyrxfs jixmvao\n" +
                   "wjdi cfgurdl usdnlk jmao qnus cicxnux vtdxxkx nusq\n" +
                   "mlvfz twu unj mar qpiz fhjczpz ytl npwjys ppq koa\n" +
                   "ippdky pvwthzj qlkhl pvwthzj\n" +
                   "kfm lcedomr xgdkrzo hfxyoe rafcby uwe pzjyuja weu nso erdwc fjvc\n" +
                   "peep oufzlb fsgn kxj uge xvufb zsnrxss lere gfsn gvwajkj fmh\n" +
                   "mexvi kgkktz kgkktz auyln ghvqc mexvi\n" +
                   "wit qxtewrk qdaz oljeb wowb suergyt hxq pfnfbei rdu qrxkwte fyw\n" +
                   "qjjzkd oxedeu uoxbehs zder vvjnn ocxkiz wkblzy eyzksc waiiqo fut raak\n" +
                   "dhojys qkusuxs kzicui dcsxo\n" +
                   "hsnexb yoz inza gqxtbc rya jqfe ufzlqva\n" +
                   "scpquf gbloz ceol eclo qpvzavo rwfnxa\n" +
                   "jyg edqf vdpsihl edqf\n" +
                   "mbyjg yjgbm mgybj mhgi grw\n" +
                   "ler oxssrel jhw jwh sfa hdhlo gng auzoan\n" +
                   "hmkuis iaxf muhisk ikshum\n" +
                   "eodbpo prajasi zsu hyb npr tbcntup uzs bxchne\n" +
                   "zpyr kxmvz frlzwnb tzqrw vdh ndbwqmu cadwsv adq bzfnrwl qfgf\n" +
                   "dybnn dmarc mknr fovokgj ukrp cuwag\n" +
                   "khweq eljs rllijp pizevm lwws kehqw mkjcu otqodz\n" +
                   "fvsrb kzbjbcc kzbjbcc mee dhyedb kzbjbcc\n" +
                   "cnlmjd dvnd vhlvsa rsrtc scrrt tqhx vke jqmxpd udkjqc qxriw pfqpk\n" +
                   "tyureg urteyg rutyge rmoihs\n" +
                   "pccxeak tkmyane qqggpr tbdmpi ieb\n" +
                   "wjucbi wjm hais pcxjd kkzh qns hmf mhf mnsv ifigsc\n" +
                   "lqeyr pnopcig cpgoinp pncpigo mjfkjus cko zedvvyq\n" +
                   "ofsnspv goj wqm ynolb qczly brl lrupzg buof zladwte\n" +
                   "xzn zxn yaseulw qwhxb easyluw vvlmh\n" +
                   "aiybip ydfczwh wkl rjsu xreokl qov mko pna fkfu\n" +
                   "zjlwozs nxke ozwlzjs jybx jpsxp qtkll idsrad savpoe\n" +
                   "xph lpvkmvy afq uqhg qqjgm smg tmhem mxdyqx bvhot lpvmkyv\n" +
                   "jxkkzil pkjheow fewr ggbfy fuol cuzud wnx fxujfwh srjsmic\n" +
                   "lzbjx vfx sncis xuv unoa nlgs stdhf oibxsgk uhogsb\n" +
                   "hfqzkms bzyfnz npcd yhfdo myqukug pjq adle sqkfhmz\n" +
                   "czhainb iazcnhb hhaqr cyrwj zzow luuvt zdyhnh uppysr\n" +
                   "fyw dulbxa drewqsr tldlaac kyaw datclal ylplup hdzbj\n" +
                   "kiiv tly gua lfg\n" +
                   "gphbvwc lqdd jqja ffpkz hafal eiapksw wsikpea vphgbcw lkcpm zjxcx\n" +
                   "viapp rxt vdgbm ezphp pcqr bll mklgx epzhp\n" +
                   "favz bwmczgg zoyns pens wpgi mrwxel\n" +
                   "ozwjjn kbzaozc cuaa igbfyq swi uypx bczaozk pyux odvawqx\n" +
                   "npnpw nwppn egnpj fkzh wppnn\n" +
                   "asu mlqmwa npewa cjluw qmalmw newpa fznx dzypi yiy\n" +
                   "hleh usw bgmgscg cqc fijfuw idtyh cgmsbgg zjhr wus hymbju\n" +
                   "tmre fvm cgowgb eduyfla ttez vdzp vtmtaog ezxsfi gyxgzi pvzd\n" +
                   "acvarlu hkmfzdg jsnil hpv wjj rljpk pygl wjhhohk rkplj spvgx psgvx\n" +
                   "wyz rvuobq kbmhaf bec bec\n" +
                   "zosyz psuo lgihdo mjtftk fjkttm ddmcd\n" +
                   "pqm qpswpb opviwxg ppqsbw waco jpx\n" +
                   "yzgumgq kqv hqjghnl jixhoyg ufer kvq lzi rojm gbhvsd urd tuy\n" +
                   "sxc jndqc ozpex wkchpu tmwv utcxzd piecpma cmppeia\n" +
                   "ifjc lttj tltj rxmgxqa jcif lzhxkg zqb mdq kbjavv\n" +
                   "isyxn zjbj uiw avziqxf zpezazx iuw\n" +
                   "rjaudu amtpuk gufogys xiqs\n" +
                   "gau sndrkv cmiolti cdxm ikkcisu xusnfbp jxffy ffcizj psye sgd\n" +
                   "mvx onzmy oynzm mwfgvs\n" +
                   "mrdg roanty dljs jlil gzcj dqitnfb gxb vzzqf ooweeh pgs oyntra\n" +
                   "yna xgok fvbdl xgko udqp sorfo hmhl yan\n" +
                   "kycl ule blupejp kycl fhpkoe pqkptw cfzpv nkncl\n" +
                   "snugkyw zfdbsfs aehb olq kkoi xpsvy jqcspf lajjyu jtm\n" +
                   "hifhfa mii clukcbc fhhifa wcts tgai vvqsyr kclcbcu\n" +
                   "ordjftj dokk hdhytwc fjodrtj ojrjfdt san ajxrwy ked jfrqc\n" +
                   "eylx cohd biswq xgiibz gzcptbf eylx icunv bfg jqanbv rntp sbfkiey\n" +
                   "kub gdpbdms qnnto bit visqop\n" +
                   "tywk clicj daics cbuewkx yyjjjka vxzk afsdyqg\n" +
                   "bmxzll wqjnyr mxlzbl yutkaa qmpz hiqkf lqqqle jagj qlqelq\n" +
                   "jgdeatg qubj jsu bhgbm swmgy lwgnuh qjbu dqwiikp mgwys\n" +
                   "ryisldg asrrhz vxvrnk ibjr kebyx dwbx qdrpa tgakt\n" +
                   "dfvgzk hifan dpjdnqc ncnvf xmqjjao npjq vobt evtaety kvufds pcugx oyjo\n" +
                   "ezionjg ioznegj cykxy igeojzn ezm\n" +
                   "dkv dkv vfqyl dkv dtjhrem\n" +
                   "xfgh brsjcdw auvq fibb gcbecl\n" +
                   "eet qdnrymr ndqmyrr tpfqxoi kbkxw\n" +
                   "qhmaj maukf uygg hqmaj tfmtv irao wsari\n" +
                   "ofoywus wxs leemkn wfko dwzqv txg qsiiiss aiiffe fadmdq zjtaovt\n" +
                   "fgfms oazi sam msgff qif evxca reho\n" +
                   "gpzhy qxh sco qeax wtabxwv sjd oev\n" +
                   "xsmpi wskvku xspmi smipx\n" +
                   "ghgf tbpeun qdivuvq dump umdp khxcxtx laljpv lownp egovve\n" +
                   "vhmu eziabt hnz neko nkz hfmizn\n" +
                   "vqhb lax zzyf lxa lik jrqynr rgcos\n" +
                   "zjgbfzv ieufyz kjxad qxeuewx\n" +
                   "ufl drkaac hoyic pqutop wqzdk eewabsr mqspcr ewarbse dzqkw\n" +
                   "bgatanj xmddwv mwlmw scgzboo myignm lkfl fsqr\n" +
                   "xkrx otjzfk wek dpbwk cromg fclmhg pkvw wsln\n" +
                   "yyqjs lifg gifl cfv lfig fycza\n" +
                   "dfup fkfeiqq rcmuv dly iforzi lngkjc rzifio oiifrz mlhor puwm qrthoa\n" +
                   "nzfaeto punt rtmlg dwdk hyig\n" +
                   "mds ueoyclh lxb axgea wqt wwqqglf tqw yvzji ryr dst bojf\n" +
                   "ayoj yzj lyctgnc woxz gqltw lkzkwte wysb mjyeu hrwso\n" +
                   "gymmvtt lhskza lsb nhlijnt men zphurrw oftksy zxs ykerwue hnijltn iknqyz\n" +
                   "xuaxkc lgzeef fwb nlzzhjj lsieg qdr ews rue rdq\n" +
                   "xnf lljcmod kyuercp kvlvd lkvh ncn afaq\n" +
                   "bjytofa ltz mkyy bwt uxca somiz rhgdg keaqu ybr\n" +
                   "aipljn qpq nilajp udgkchc dirvxg rrbmi mxfxkk kmfxkx\n" +
                   "sfzjemk hjsvnmb hfd hprfmvg pbhkc\n" +
                   "cvxi srj ucy yuc euswuns jpox\n" +
                   "tajlnn ivuecv fdfce rakjq bfuxirh eibde tajnln nlajtn\n" +
                   "ndvm mlnhy bfqlzn nmdv ohto\n" +
                   "jysyvwy xbcyt lbbm osoye swwtwa emfznci qnzc qsgk\n" +
                   "xcm jbqsuo xmc mtrk bojuqs\n" +
                   "ukshrrh xhfl ooxgq vadlcrg ydva hugplg mnqbd wkyouq\n" +
                   "mnmqys bhws megar krgoke modxe krgoke clovh dlo\n" +
                   "ejl qzc agxph jcn zcq zqc\n" +
                   "jgh yhh hjg jhg\n" +
                   "tarm jboyg gbyjo pgalg xugzt bph mart\n" +
                   "yur wrrahr fnnfqu rwhrar cdq\n" +
                   "mukod gueg guge epalg xjkctt\n" +
                   "hub hbu hbzul buh sqfl\n" +
                   "xyrly lvpitr xfzn jjcl uvcnz dnpdyzq ifaiwe zlvzcx\n" +
                   "wxzsf tgd khvwp cmd mzv bsvjvjm wvhpk ublnqyz mvbjvjs peishcb\n" +
                   "zunmk hxpney nphxey znmku\n" +
                   "bfxlgur wftcw xfkf fsik xkff ffxk\n" +
                   "sxyjzr ugcscx uiovqx ldzhord xgxbfph ldzhord prdhg rhdhzd ugcscx\n" +
                   "udg drb apyjq dgyevo fuxjhg\n" +
                   "qshbe aigfdp wyvz xfcos wve dgfrufw dwimmb jfh wfrjbzk nwgrigr sbrpbb\n" +
                   "ahpn xnzeof wxbv chxpcu jmso age ojsm bqonfki hqhrkw\n" +
                   "mfupm vvig ndqbbm jlw\n" +
                   "ejqh ebcrytj zpiqtpp ogznd\n" +
                   "wkwkae odq rsrnqk nslczz hiyyhur kuw mjbuwll vduvod ryhuhiy swo tsos\n" +
                   "znkufyx jejrdno knr wkx ikrlly tnxtj\n" +
                   "iizdiw iizdiw hukep rwj eaq ptm klta rwj onaz\n" +
                   "znb egqy qqnc igqr ikza ojgzkr xaen kurb pyckxvt wqx\n" +
                   "pbohpw bphowp dajwdpp kotevs\n" +
                   "hmuvxu zdnguk jhcmj gccyxiu cxgiycu uyxcgic akxi demeff\n" +
                   "zjr lupzwcy puva rzj\n" +
                   "cdn wee iqkbhl jwxo nhl cqd mqgqf ltdfg\n" +
                   "phwco ggcj cggj ergpqmc kcz\n" +
                   "aryjl wqwmkc aklktpz kptnroc mckqww\n" +
                   "jadydt atjdyd tajdyd owswsgm\n" +
                   "dshqt kacoge sdqth ylobih\n" +
                   "kdnik knkdi dinkk xwvqa gvii\n" +
                   "cifbkpt zye xhwnrhm fctibpk sbn pdqry emkye kzyjpa plzkc btkfcip gcchi\n" +
                   "kekfr fufp dfy eqebgko obbn nuh\n" +
                   "zixfbus skuf bea gimbqq caubhto eba uvkovz xisfzub peukmyn\n" +
                   "okihcgh gazrc slee vlnwyg geviex eesl nmnvk rcbv ycupyw\n" +
                   "tcvlgqs wxe lusvwzy unr yzluwvs wsylvzu zkwth qdykv\n" +
                   "hyenkj ugao vlwgb putcepr lyeccs fqdotx burf aqew fje rfbu\n" +
                   "uhmnc zgnkarz gylqawm abl zimcz qbs zzmic\n" +
                   "pxkbpn zuxlwtt rlbhegv zlxuwtt ooxpr pgjx\n" +
                   "leg wavgps fcplfpc xvxih ueskmi dvu wbiq nvtia pwjojw usiemk ojwwjp\n" +
                   "zmrpknx xrfpq avque tvoyqp\n" +
                   "lyposyj mckyoub sqbl olpsjyy hjafzi wmojb nvezofd\n" +
                   "yflxrg egi aij qvc yflxrg typbs yflxrg kliexy eqnj jqrr\n" +
                   "gggt sht kdajvz sht gkqwaot sht vout\n" +
                   "ahl aucpih feig man umtchcv ceqabr tfptb\n" +
                   "ftlywun voaorf kde ilwt hlpoe pksqxyh vpg cxo xgq fdkkl sgxhnq\n" +
                   "zzekhfi akb lupta sgtd qapznzf lgidsx lidsgx akgmq ettuwjq xyumf\n" +
                   "dxhpku lwoxpim gwb lhjmoh gxqapd ntmvc rvwwszg pvin lwoxpim coubc\n" +
                   "qia bxmremo rjf vaeio eqexwz wuoz sguf bsbusof xqeewz\n" +
                   "iczzz krf hbq tsgrih mzjabrt sfnwrm djignf zwac cwaz dgc nsrfmw\n" +
                   "yvarsva zzpbp yai und kkbinr zlyj nyxxof ggrgu vyk eib\n" +
                   "nepzm yrrgr vrlhbv hykmiog natrqx jvpq nbyhe zuo grx nwl\n" +
                   "cfboeev hcn yfobyx cqvlo obctww xxaux ofybxy wouguq avuztl xmgqq xyofby\n" +
                   "tikv uvzp oxopqy reh uzvp wefka vli kied gngks vbz thfsxyt\n" +
                   "exxvknp pucbdyl dboto tzat qze xyinygz mhzl ubahr ekxbtk\n" +
                   "jcz ufszbi pknsfgb ivok ijau okxolj etecn aurun zsa gbxs uryx\n" +
                   "ypnb ousd osg mvset ipffzdn dfinfpz ltescx\n" +
                   "taeoct aoetct aocett ttda fcdqnxv\n" +
                   "bimtlk ssax bmrifkr vfxdmq hglp rgzr zpvk zhxtq rndwy mmr arkr\n" +
                   "bwvdb axxbhzk nwfmbbu kzuc sahv cvas wdac acsv\n" +
                   "xavkwou yvx ouwkxva otbe uzr mmw atq yiy ghavd qta pqlhv\n" +
                   "omzht vsdsc zhtmo hmotz\n" +
                   "eqt wtveez syift shtfnc hmckjxa apwbvn yme okdl hbihdtv hxahns eetvwz\n" +
                   "rokdg ndjw hprxjc viys mbcctod dbvd\n" +
                   "lhzb fyxf xaslmi sjd vqp grxhmfe snetfv mgivd uaknj givkdi\n" +
                   "gxkxl kqcdnl rna jhcuepd npiedg djcpheu huce njryw bjluhq bvedvl kqxu\n" +
                   "sogh uym atpzuwx vjgbe xgrvkg thgbyn mptcebt rkro\n" +
                   "tnpxw uxrqxd lajmsmr tnnlt vrvbf deret hkmvrs eubvkn kks hjq\n" +
                   "rcdoa zfja vod supip dvo\n" +
                   "zbxdo xglqv how mgoq jqrdou pwrminc lidi nfs xglqv lidi\n" +
                   "ldmnp dnqn ahhr tha mvsbsfh rpm rgus faf tjash\n" +
                   "ewrdol jqhfpf rckj mrxlwj redjg bmxprx grla\n" +
                   "rhr jksebwa vtu skwaejb vut\n" +
                   "wrx iqvrjh atrt xrw vtqo tkcasd xedjh zkqrh vvhj\n" +
                   "owc qlzygar uajwwe obzl inxawur\n" +
                   "crbtrf phvy nzipo rctbfr trrcbf\n" +
                   "vwuun wcfhhzo vxxjdt fbf bqtmmhs bffqcna\n" +
                   "wkxfxmv zmrkyh sggw whwcw zukynw\n" +
                   "lsdiy lnbn kblxi qfyib irfl mymrr zqbl\n" +
                   "gwdkeu ghn afry zxoz fary uzntlnk kee xtnop ptnox zngoran\n" +
                   "lgs lsg sgeseiz gsl\n" +
                   "erpoqpi svtnv vsogl uym amzxbs\n" +
                   "jtmodqx yjcsfcl zosugm jrekfdw xxbdqnx fcha\n" +
                   "vio tlfxokx xaoq pydeiq glxsuzm honifvf maiuzsy uizsyam eco\n" +
                   "ophcui saka qyt ltti syw\n" +
                   "qff qff sde ryv\n" +
                   "eiii jazx nlehtx tnhvxl rzvsjo qkupif feypppe tefxr wdjmlc\n" +
                   "pdrr mwuy wccd rxla drpr enbbap\n" +
                   "pclml ubwdbz hfudj gdpujfm ovabv\n" +
                   "uink ffebi wdvhqzs qiympf lqxihty vnsp wdvhqzs hutxkcs lxfuos hutxkcs\n" +
                   "fycoaw palkpz yrkg kappzl ncjym mergg kryg\n" +
                   "eqy npvgh ghafkro piqnogb polacs qye hnvpg\n" +
                   "dxyy udhmz jij tqsuic qxz erctv\n" +
                   "urum nmbr cgek eetmhj gxr oxgukf wzdmvi oibzt fxkoug rcrywcr rglx\n" +
                   "jkp ofej waibl opqhmww ifnczcg jdtkbc lil isc ill mylvuv\n" +
                   "vqbcosk yhhsy gasmj bspx peakt cjtekw hvzo ywe qcvbosk ohzv qddt\n" +
                   "edq llbvsx vedyvlm gou wkecank rkgf ziyrr belgo tbz\n" +
                   "wbome vhzf ztk zaxiu ywjb supuf beq sxq spuuf pufus\n" +
                   "femu ymkdoew kjynct aia\n" +
                   "yjymr orovqj aremii licw bdtnc\n" +
                   "uyade fbx duaye ujtvpn\n" +
                   "yzvp pvzgjp yofcvya gvkkoh cafyvoy mhsm okhkvg\n" +
                   "xuh qkaf dmi imd tzmlce mqkxj qilrc dim cadotvy\n" +
                   "azpqgb kyc aflgyaf laagffy kesmk jzyzaer taf bpkbzdg\n" +
                   "ogd dbdlh dqt zaaloh\n" +
                   "exal vgnfx omu omepvwf szcwq snz bptite bzqyxl khmblyc sse emg\n" +
                   "yqcbwsn aihhf tqck tcqk wqwqy cfez xahpn\n" +
                   "qqbuf lil ies tqu pyxhqp mnfuk azj\n" +
                   "vwma rzdtgl mxbasw nwgjav mwav\n" +
                   "itpjfq rrgyt hralwm fqrig btwcod\n" +
                   "ydjd kmk fvwr wrfv yvhw mkk\n" +
                   "xbsxub yhsj xzbuf ace xubbsx fzuxb vxk\n" +
                   "ttsist vubpf mhwkmtx vlj hdsva kmmhtwx ukxr upfvb tbma fxsrnxl hzwufho\n" +
                   "wckjvz unmtev egxts ihw topvw ptowv rnihhmq\n" +
                   "gpdtl kcric nwg ssbs qah aarp ydsdty ngw\n" +
                   "lzhxbbq oktvcw xbasqe owtmwgp koa gumjie sodwrp hqsw aqh dtgsbb\n" +
                   "xjbyy mxfxa ogvk nqiy qyni ldqwryj niyq jjixc\n" +
                   "uhbul daccgva xtiz dim uhbul yjmakv yjmakv\n" +
                   "huo esajup ouj oju ujo\n" +
                   "eeeu hwvsk jfkmds okhi pogskfm itdlbll\n" +
                   "lpyubo dylpfb iehwug decj ntidy cuygyg lalkb iutu oxgm imn";
        // System.out.println(solve(s));
        // System.out.println(solve("aa bb cc dd aaa"));
        System.out.println(solve2Anagram(s));
        System.out.println(solve2Anagram("aa bb cc dd aaa"));
    }

    private static int solve(String s) {
        String[] a = s.split("\n");
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            Set<String> set = new HashSet<>();
            String[] temp = a[i].split(" ");
            int cc = 0;
            for (int j = 0; j < temp.length; j++) {
                if (!set.add(temp[j]))
                    break;
                cc++;
            }
            if (cc == temp.length)
                count++;
        }
        return count;
    }

    private static int solve2Anagram(String s) {
        String[] a = s.split("\n");
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            boolean yes = true;
            String[] line = a[i].split(" ");

            for (int j = 0; j < line.length; j++) {
                for (int k = j + 1; k < line.length; k++) {
                    if (Arrays.equals(parse(line[j]), parse(line[k]))) {
                        yes = false;
                        break;
                    }
                }
            }
            if (yes)
                count++;
        }
        return count;
    }

    private static int[] parse(String line) {
        int[] firstWord = new int[26];
        for (int j = 0; j < line.length(); j++) {
            firstWord[line.charAt(j) - 'a']++;
        }
        return firstWord;
    }

}
