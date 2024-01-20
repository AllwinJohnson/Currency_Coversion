package com.allwin.currencycoversion.data.model.currency

import com.google.gson.annotations.SerializedName

data class CurrencyResponse(

    @field:SerializedName("license")
    val license: String? = null,

    @field:SerializedName("rates")
    val rates: Rates? = null,

    @field:SerializedName("disclaimer")
    val disclaimer: String? = null,

    @field:SerializedName("timestamp")
    val timestamp: Double? = null,

    @field:SerializedName("base")
    val base: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("error")
    val error: Boolean? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("status")
    val status: Double? = null
)

data class Rates(
    @field:SerializedName("FJD")
    val FJD: Double? = null,

    @field:SerializedName("MXN")
    val MXN: Double? = null,

    @field:SerializedName("STD")
    val STD: Double? = null,

    @field:SerializedName("SCR")
    val SCR: Double? = null,

    @field:SerializedName("CDF")
    val CDF: Double? = null,

    @field:SerializedName("BBD")
    val BBD: Double? = null,

    @field:SerializedName("GTQ")
    val GTQ: Double? = null,

    @field:SerializedName("CLP")
    val CLP: Double? = null,

    @field:SerializedName("HNL")
    val HNL: Double? = null,

    @field:SerializedName("UGX")
    val UGX: Double? = null,

    @field:SerializedName("ZAR")
    val ZAR: Double? = null,

    @field:SerializedName("TND")
    val TND: Double? = null,

    @field:SerializedName("STN")
    val STN: Double? = null,

    @field:SerializedName("CUC")
    val CUC: Double? = null,

    @field:SerializedName("BSD")
    val BSD: Double? = null,

    @field:SerializedName("SLL")
    val SLL: Double? = null,

    // ... continue for other properties

    @field:SerializedName("SDG")
    val SDG: Double? = null,

    @field:SerializedName("IQD")
    val IQD: Double? = null,

    @field:SerializedName("CUP")
    val CUP: Double? = null,

    @field:SerializedName("GMD")
    val GMD: Double? = null,

    @field:SerializedName("TWD")
    val TWD: Double? = null,

    @field:SerializedName("RSD")
    val RSD: Double? = null,

    @field:SerializedName("DOP")
    val DOP: Double? = null,

    @field:SerializedName("KMF")
    val KMF: Double? = null,

    @field:SerializedName("MYR")
    val MYR: Double? = null,

    @field:SerializedName("FKP")
    val FKP: Double? = null,

    @field:SerializedName("XOF")
    val XOF: Double? = null,

    @field:SerializedName("GEL")
    val GEL: Double? = null,

    @field:SerializedName("BTC")
    val BTC: Double? = null,

    @field:SerializedName("UYU")
    val UYU: Double? = null,

    @field:SerializedName("MAD")
    val MAD: Double? = null,

    @field:SerializedName("CVE")
    val CVE: Double? = null,

    @field:SerializedName("TOP")
    val TOP: Double? = null,

    @field:SerializedName("AZN")
    val AZN: Double? = null,

    @field:SerializedName("OMR")
    val OMR: Double? = null,

    @field:SerializedName("PGK")
    val PGK: Double? = null,

    @field:SerializedName("KES")
    val KES: Double? = null,

    @field:SerializedName("SEK")
    val SEK: Double? = null,

    @field:SerializedName("CNH")
    val CNH: Double? = null,

    @field:SerializedName("BTN")
    val BTN: Double? = null,

    @field:SerializedName("UAH")
    val UAH: Double? = null,

    @field:SerializedName("GNF")
    val GNF: Double? = null,

    @field:SerializedName("ERN")
    val ERN: Double? = null,

    @field:SerializedName("MZN")
    val MZN: Double? = null,

    @field:SerializedName("SVC")
    val SVC: Double? = null,

    @field:SerializedName("ARS")
    val ARS: Double? = null,

    @field:SerializedName("QAR")
    val QAR: Double? = null,

    @field:SerializedName("IRR")
    val IRR: Double? = null,

    @field:SerializedName("XPD")
    val XPD: Double? = null,

    @field:SerializedName("CNY")
    val CNY: Double? = null,

    @field:SerializedName("THB")
    val THB: Double? = null,

    @field:SerializedName("UZS")
    val UZS: Double? = null,

    @field:SerializedName("XPF")
    val XPF: Double? = null,

    @field:SerializedName("MRU")
    val MRU: Double? = null,

    @field:SerializedName("BDT")
    val BDT: Double? = null,

    @field:SerializedName("LYD")
    val LYD: Double? = null,

    @field:SerializedName("BMD")
    val BMD: Double? = null,

    @field:SerializedName("KWD")
    val KWD: Double? = null,

    @field:SerializedName("PHP")
    val PHP: Double? = null,

    @field:SerializedName("XPT")
    val XPT: Double? = null,

    @field:SerializedName("RUB")
    val RUB: Double? = null,

    @field:SerializedName("PYG")
    val PYG: Double? = null,

    @field:SerializedName("ISK")
    val ISK: Double? = null,

    @field:SerializedName("JMD")
    val JMD: Double? = null,

    @field:SerializedName("COP")
    val COP: Double? = null,

    @field:SerializedName("MKD")
    val MKD: Double? = null,

    @field:SerializedName("USD")
    val USD: Double? = null,

    @field:SerializedName("DZD")
    val DZD: Double? = null,

    @field:SerializedName("PAB")
    val PAB: Double? = null,

    @field:SerializedName("GGP")
    val GGP: Double? = null,

    @field:SerializedName("SGD")
    val SGD: Double? = null,

    @field:SerializedName("ETB")
    val ETB: Double? = null,

    @field:SerializedName("JEP")
    val JEP: Double? = null,

    @field:SerializedName("KGS")
    val KGS: Double? = null,

    @field:SerializedName("SOS")
    val SOS: Double? = null,

    @field:SerializedName("VUV")
    val VUV: Double? = null,

    @field:SerializedName("LAK")
    val LAK: Double? = null,

    @field:SerializedName("BND")
    val BND: Double? = null,

    @field:SerializedName("XAF")
    val XAF: Double? = null,

    @field:SerializedName("LRD")
    val LRD: Double? = null,

    @field:SerializedName("XAG")
    val XAG: Double? = null,

    @field:SerializedName("CHF")
    val CHF: Double? = null,

    @field:SerializedName("HRK")
    val HRK: Double? = null,

    @field:SerializedName("ALL")
    val ALL: Double? = null,

    @field:SerializedName("DJF")
    val DJF: Double? = null,

    @field:SerializedName("VES")
    val VES: Double? = null,

    @field:SerializedName("ZMW")
    val ZMW: Double? = null,

    @field:SerializedName("TZS")
    val TZS: Double? = null,

    @field:SerializedName("VND")
    val VND: Double? = null,

    @field:SerializedName("XAU")
    val XAU: Double? = null,

    @field:SerializedName("AUD")
    val AUD: Double? = null,

    @field:SerializedName("ILS")
    val ILS: Double? = null,

    @field:SerializedName("GHS")
    val GHS: Double? = null,

    @field:SerializedName("GYD")
    val GYD: Double? = null,

    @field:SerializedName("KPW")
    val KPW: Double? = null,

    @field:SerializedName("BOB")
    val BOB: Double? = null,

    @field:SerializedName("KHR")
    val KHR: Double? = null,

    @field:SerializedName("MDL")
    val MDL: Double? = null,

    @field:SerializedName("IDR")
    val IDR: Double? = null,

    @field:SerializedName("KYD")
    val KYD: Double? = null,

    @field:SerializedName("AMD")
    val AMD: Double? = null,

    @field:SerializedName("BWP")
    val BWP: Double? = null,

    @field:SerializedName("SHP")
    val SHP: Double? = null,

    @field:SerializedName("TRY")
    val TRY: Double? = null,

    @field:SerializedName("LBP")
    val LBP: Double? = null,

    @field:SerializedName("TJS")
    val TJS: Double? = null,

    @field:SerializedName("JOD")
    val JOD: Double? = null,

    @field:SerializedName("AED")
    val AED: Double? = null,

    @field:SerializedName("HKD")
    val HKD: Double? = null,

    @field:SerializedName("RWF")
    val RWF: Double? = null,

    @field:SerializedName("EUR")
    val EUR: Double? = null,

    @field:SerializedName("LSL")
    val LSL: Double? = null,

    @field:SerializedName("DKK")
    val DKK: Double? = null,

    @field:SerializedName("CAD")
    val CAD: Double? = null,

    @field:SerializedName("BGN")
    val BGN: Double? = null,

    @field:SerializedName("MMK")
    val MMK: Double? = null,

    @field:SerializedName("MUR")
    val MUR: Double? = null,

    @field:SerializedName("NOK")
    val NOK: Double? = null,

    @field:SerializedName("SYP")
    val SYP: Double? = null,

    @field:SerializedName("IMP")
    val IMP: Double? = null,

    @field:SerializedName("ZWL")
    val ZWL: Double? = null,

    @field:SerializedName("GIP")
    val GIP: Double? = null,

    @field:SerializedName("RON")
    val RON: Double? = null,

    @field:SerializedName("LKR")
    val LKR: Double? = null,

    @field:SerializedName("NGN")
    val NGN: Double? = null,

    @field:SerializedName("CRC")
    val CRC: Double? = null,

    @field:SerializedName("CZK")
    val CZK: Double? = null,

    @field:SerializedName("PKR")
    val PKR: Double? = null,

    @field:SerializedName("XCD")
    val XCD: Double? = null,

    @field:SerializedName("ANG")
    val ANG: Double? = null,

    @field:SerializedName("HTG")
    val HTG: Double? = null,

    @field:SerializedName("BHD")
    val BHD: Double? = null,

    @field:SerializedName("KZT")
    val KZT: Double? = null,

    @field:SerializedName("SRD")
    val SRD: Double? = null,

    @field:SerializedName("SZL")
    val SZL: Double? = null,

    @field:SerializedName("SAR")
    val SAR: Double? = null,

    @field:SerializedName("TTD")
    val TTD: Double? = null,

    @field:SerializedName("YER")
    val YER: Double? = null,

    @field:SerializedName("MVR")
    val MVR: Double? = null,

    @field:SerializedName("AFN")
    val AFN: Double? = null,

    @field:SerializedName("INR")
    val INR: Double? = null,

    @field:SerializedName("AWG")
    val AWG: Double? = null,

    @field:SerializedName("KRW")
    val KRW: Double? = null,

    @field:SerializedName("NPR")
    val NPR: Double? = null,

    @field:SerializedName("JPY")
    val JPY: Double? = null,

    @field:SerializedName("MNT")
    val MNT: Double? = null,

    @field:SerializedName("AOA")
    val AOA: Double? = null,

    @field:SerializedName("PLN")
    val PLN: Double? = null,

    @field:SerializedName("GBP")
    val GBP: Double? = null,

    @field:SerializedName("SBD")
    val SBD: Double? = null,

    @field:SerializedName("BYN")
    val BYN: Double? = null,

    @field:SerializedName("HUF")
    val HUF: Double? = null,

    @field:SerializedName("BIF")
    val BIF: Double? = null,

    @field:SerializedName("MWK")
    val MWK: Double? = null,

    @field:SerializedName("MGA")
    val MGA: Double? = null,

    @field:SerializedName("XDR")
    val XDR: Double? = null,

    @field:SerializedName("BZD")
    val BZD: Double? = null,

    @field:SerializedName("BAM")
    val BAM: Double? = null,

    @field:SerializedName("EGP")
    val EGP: Double? = null,

    @field:SerializedName("MOP")
    val MOP: Double? = null,

    @field:SerializedName("NAD")
    val NAD: Double? = null,

    @field:SerializedName("SSP")
    val SSP: Double? = null,

    @field:SerializedName("NIO")
    val NIO: Double? = null,

    @field:SerializedName("PEN")
    val PEN: Double? = null,

    @field:SerializedName("NZD")
    val NZD: Double? = null,

    @field:SerializedName("WST")
    val WST: Double? = null,

    @field:SerializedName("TMT")
    val TMT: Double? = null,

    @field:SerializedName("CLF")
    val CLF: Double? = null,

    @field:SerializedName("BRL")
    val BRL: Double? = null
)