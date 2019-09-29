package com.github.onotoliy.kotlinx.components.svg

import kotlinx.html.HTMLTag
import react.RBuilder
import react.ReactElement
import react.dom.RDOMBuilder
import react.dom.svg
import react.dom.tag

private inline fun RBuilder.custom(tagName: String, block: RDOMBuilder<HTMLTag>.() -> Unit): ReactElement = tag(block) {
    HTMLTag(tagName, it, mapOf(), null, true, false)
}

fun RBuilder.svgLogoOpposite() {
    svg {
        attrs["width"] = "198"
        attrs["height"] = "34"
        attrs["viewBox"] = "0 0 198 34"
        custom("image") {
            attrs["id"] = "image0"
            attrs["width"] = "200"
            attrs["height"] = "30"
            attrs["xlinkHref"] = "data:img/png;base64,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"
        }
    }
}

fun RBuilder.svgSettingsGear(isActive: Boolean = false) {
    svg {
        attrs["width"] = "20"
        attrs["height"] = "20"
        attrs["viewBox"] = "0 0 20 20"
        custom("path") {
            attrs["fillRule"] = "evenodd"
            attrs["clipRule"] = "evenodd"
            attrs["d"] = "M1.74703 8.34935C1.56268 8.02034 1.41691 7.66969 1.31188 7.30606L0.480172 7.20863C0.205788 7.17616 0 6.9424 0 6.66534V5.37313C0 5.09608 0.205788 4.86231 0.480172 4.82984L1.26902 4.73893C1.36763 4.34067 1.51768 3.95755 1.7149 3.59824L1.22186 2.96837C1.05038 2.74976 1.06752 2.43807 1.26259 2.2411L2.1672 1.32768C2.36227 1.13287 2.67095 1.11339 2.88746 1.28655L3.47696 1.75842C3.85423 1.53114 4.25938 1.35798 4.68382 1.24326L4.76956 0.50084C4.80171 0.223783 5.03323 0.0159912 5.30761 0.0159912H6.58735C6.86174 0.0159912 7.09325 0.223783 7.1254 0.50084L7.21115 1.24326C7.62484 1.35582 8.01929 1.52248 8.388 1.7411L8.95606 1.28655C9.17256 1.11339 9.48124 1.13071 9.67631 1.32768L10.5788 2.23893C10.7717 2.4359 10.791 2.74759 10.6195 2.96621L10.1565 3.55712C10.3537 3.9121 10.508 4.29088 10.6109 4.68699L11.3633 4.77573C11.6377 4.8082 11.8435 5.04197 11.8435 5.31902V6.61123C11.8435 6.88829 11.6377 7.12205 11.3633 7.15452L10.6002 7.24326C10.493 7.6437 10.3322 8.02679 10.1265 8.38612L10.6216 9.02032C10.7931 9.23893 10.776 9.55062 10.5809 9.74759L9.67629 10.661C9.48122 10.8558 9.17254 10.8753 8.95603 10.7021L8.31938 10.1935C7.95711 10.3991 7.57125 10.5571 7.16825 10.6632L7.07393 11.4879C7.04178 11.7649 6.81027 11.9727 6.53588 11.9727H5.25614C4.98176 11.9727 4.75025 11.7649 4.71809 11.4879L4.61949 10.6329C4.24435 10.5246 3.88422 10.371 3.54553 10.174L2.88744 10.7C2.67093 10.8731 2.36225 10.8558 2.16718 10.6589L1.26257 9.74545C1.06965 9.54848 1.05035 9.23679 1.22184 9.01818L1.74703 8.34935ZM8.06429 5.94675C8.06429 4.76926 7.11466 3.81039 5.94853 3.81039C4.7824 3.81039 3.83278 4.76926 3.83278 5.94675C3.83278 7.12424 4.78242 8.08311 5.94853 8.08311C7.11466 8.08311 8.06429 7.12424 8.06429 5.94675Z"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
        custom("path") {
            attrs["fillRule"] = "evenodd"
            attrs["clipRule"] = "evenodd"
            attrs["d"] = "M17.9252 7.04844L18.6005 7.6242C18.8084 7.80169 18.8513 8.10904 18.6969 8.33844L18.4033 8.78433C18.5898 9.0614 18.7398 9.36008 18.8513 9.6761L19.3894 9.69342C19.6616 9.70208 19.8824 9.91636 19.906 10.1891L19.981 11.0787C20.0024 11.3514 19.8181 11.6004 19.5523 11.6545L19.0164 11.7649C18.9564 12.0982 18.8513 12.4229 18.7077 12.7303L19.1 13.1501C19.2865 13.3493 19.295 13.6588 19.1193 13.8688L18.5491 14.5506C18.3733 14.7605 18.0711 14.8038 17.8438 14.6523L17.3572 14.3276C17.0764 14.5203 16.772 14.6761 16.4505 14.7908L16.4312 15.3882C16.4226 15.6632 16.2104 15.8861 15.9403 15.9099L15.0593 15.9856C14.7892 16.0073 14.5427 15.8211 14.4891 15.5527L14.3669 14.9424C14.0539 14.8818 13.7495 14.78 13.4601 14.6437L13.0185 15.0614C12.8213 15.2497 12.5148 15.2584 12.3068 15.0809L11.6316 14.5051C11.4237 14.3276 11.3808 14.0224 11.5309 13.793L11.8674 13.28C11.6938 13.0225 11.5502 12.7476 11.4408 12.4575L10.8384 12.438C10.5662 12.4294 10.3454 12.2151 10.3218 11.9424L10.2468 11.0528C10.2254 10.78 10.4097 10.5311 10.6755 10.477L11.2329 10.3623C11.2886 10.0311 11.3851 9.70859 11.5201 9.40123L11.13 8.98134C10.9435 8.78221 10.9349 8.47268 11.1107 8.26272L11.6809 7.57658C11.8567 7.36662 12.1589 7.32333 12.3862 7.47485L12.832 7.77355C13.1236 7.56143 13.443 7.39259 13.7817 7.26922L13.7988 6.74108C13.8074 6.46619 14.0196 6.24324 14.2897 6.21943L15.1707 6.14368C15.4409 6.12203 15.6874 6.30818 15.741 6.57658L15.846 7.09606C16.1911 7.15883 16.5255 7.26705 16.8406 7.42073L17.2136 7.06792C17.4108 6.87961 17.7173 6.87095 17.9252 7.04844ZM13.4087 11.1718C13.4879 12.1328 14.3283 12.8493 15.2801 12.767C16.2318 12.687 16.9414 11.8385 16.8599 10.8774C16.7806 9.9164 15.9403 9.19993 14.9885 9.28218C14.0368 9.36227 13.3272 10.2108 13.4087 11.1718Z"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
        custom("path") {
            attrs["fillRule"] = "evenodd"
            attrs["clipRule"] = "evenodd"
            attrs["d"] = "M3.9147 15.6934C3.91684 15.4185 4.12478 15.1891 4.39487 15.161L4.76999 15.122C4.83858 14.8558 4.94362 14.6025 5.07652 14.3644L4.84716 14.0657C4.67995 13.8471 4.70139 13.5397 4.89646 13.3471L5.2866 12.9618C5.48167 12.7692 5.78608 12.7562 5.9983 12.9293L6.26626 13.1501C6.5192 13.003 6.79144 12.8904 7.07438 12.8168L7.11725 12.4791C7.15157 12.2064 7.38308 12.0029 7.65532 12.0073L8.19766 12.0138C8.46992 12.0159 8.69712 12.2259 8.72499 12.4986L8.75931 12.8384C9.03367 12.9164 9.29522 13.0311 9.53957 13.1804L9.79897 12.9791C10.0155 12.8103 10.3199 12.8319 10.5107 13.0289L10.8901 13.4207C11.0809 13.6177 11.0937 13.925 10.9222 14.1393L10.7057 14.4077C10.8343 14.6458 10.9329 14.9012 10.9994 15.1653L11.3467 15.2107C11.6168 15.2454 11.8183 15.4792 11.814 15.754L11.8075 16.3017C11.8054 16.5766 11.5975 16.806 11.3274 16.8341L10.9715 16.8709C10.8965 17.1372 10.7872 17.3904 10.6457 17.6285L10.8751 17.9294C11.0423 18.148 11.0208 18.4554 10.8258 18.648L10.4378 19.0311C10.2427 19.2238 9.93828 19.2368 9.72606 19.0636L9.42596 18.819C9.1816 18.9532 8.92437 19.0549 8.65425 19.122L8.60495 19.516C8.57065 19.7887 8.33912 19.9922 8.0669 19.9878L7.52454 19.9813C7.2523 19.9792 7.02508 19.7692 6.99721 19.4965L6.95434 19.0809C6.7057 19.0073 6.46773 18.9013 6.24265 18.7671L5.92328 19.016C5.70677 19.1848 5.40238 19.1632 5.21159 18.9662L4.83217 18.5744C4.64139 18.3774 4.62853 18.0701 4.80002 17.8558L5.05725 17.5355C4.93507 17.3147 4.84075 17.0809 4.77429 16.8363L4.37558 16.7844C4.10548 16.7497 3.90398 16.5159 3.90827 16.2411L3.9147 15.6934ZM9.28876 15.9835C9.29732 15.1978 8.67354 14.5506 7.89541 14.5419C7.11727 14.5333 6.47633 15.1631 6.46773 15.9488C6.45918 16.7346 7.08295 17.3818 7.86109 17.3904C8.63922 17.399 9.28019 16.7692 9.28876 15.9835Z"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
    }
}

fun RBuilder.svgFiles(isActive: Boolean = false) {
    svg {
        attrs["width"] = "20"
        attrs["height"] = "20"
        attrs["viewBox"] = "0 0 20 20"
        custom("path") {
            attrs["fillRule"] = "evenodd"
            attrs["clipRule"] = "evenodd"
            attrs["d"] = "M18 0H6C4.9 0 4 0.9 4 2V14C4 15.1 4.9 16 6 16H18C19.1 16 20 15.1 20 14V2C20 0.9 19.1 0 18 0ZM2 4H0V18C0 19.1 0.9 20 2 20H16V18H2V4ZM7 9H17V7H7V9ZM13 13H7V11H13V13ZM7 5H17V3H7V5Z"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
    }
}

fun RBuilder.svgCoinStack(isActive: Boolean = false) {
    svg {
        attrs["width"] = "19"
        attrs["height"] = "17"
        attrs["viewBox"] = "0 0 19 17"
        custom("path") {
            attrs["fillRule"] = "evenodd"
            attrs["clipRule"] = "evenodd"
            attrs["d"] = "M5.51477 9.84523C6.04819 9.84523 6.56379 9.81061 7.05169 9.74618V4.37318C6.56384 4.30879 6.04819 4.27417 5.51477 4.27417C2.46905 4.27417 0 5.39926 0 6.78718V7.33218C0 8.72005 2.46905 9.84523 5.51477 9.84523Z"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
        custom("path") {
            attrs["fillRule"] = "evenodd"
            attrs["clipRule"] = "evenodd"
            attrs["d"] = "M5.51477 12.6508C6.04819 12.6508 6.56379 12.6162 7.05169 12.5519V10.9769C6.5637 11.0413 6.04833 11.0764 5.51477 11.0764C2.85619 11.0764 0.637209 10.2191 0.115985 9.07812C0.0400796 9.24433 0 9.41642 0 9.59283V10.1378C0 11.5257 2.46905 12.6508 5.51477 12.6508Z"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
        custom("path") {
            attrs["fillRule"] = "evenodd"
            attrs["clipRule"] = "evenodd"
            attrs["d"] = "M7.05169 13.905V13.7826C6.5637 13.847 6.04833 13.8821 5.51477 13.8821C2.85619 13.8821 0.637209 13.0248 0.115985 11.8838C0.0400796 12.0499 0 12.222 0 12.3984V12.9434C0 14.3314 2.46905 15.4565 5.51477 15.4565C6.12386 15.4565 6.70969 15.4114 7.25753 15.3283C7.12174 15.0492 7.05169 14.7549 7.05169 14.45V13.905Z"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
        custom("path") {
            attrs["fillRule"] = "evenodd"
            attrs["clipRule"] = "evenodd"
            attrs["d"] = "M13.4659 0.0180054C10.4202 0.0180054 7.95117 1.14309 7.95117 2.53101V3.07601C7.95117 4.46393 10.4202 5.58902 13.4659 5.58902C16.5116 5.58902 18.9807 4.46393 18.9807 3.07601V2.53101C18.9807 1.14309 16.5116 0.0180054 13.4659 0.0180054Z"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
        custom("path") {
            attrs["fillRule"] = "evenodd"
            attrs["clipRule"] = "evenodd"
            attrs["d"] = "M13.4659 6.82021C10.8074 6.82021 8.58838 5.96294 8.06716 4.8219C7.99125 4.98805 7.95117 5.16014 7.95117 5.3366V5.8816C7.95117 7.26952 10.4202 8.39461 13.4659 8.39461C16.5116 8.39461 18.9807 7.26952 18.9807 5.8816V5.3366C18.9807 5.16014 18.9406 4.98805 18.8647 4.8219C18.3435 5.96294 16.1245 6.82021 13.4659 6.82021Z"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
        custom("path") {
            attrs["fillRule"] = "evenodd"
            attrs["clipRule"] = "evenodd"
            attrs["d"] = "M13.4659 9.62587C10.8074 9.62587 8.58838 8.76856 8.06716 7.62756C7.99125 7.79372 7.95117 7.96581 7.95117 8.14226V8.68726C7.95117 10.0752 10.4202 11.2003 13.4659 11.2003C16.5116 11.2003 18.9807 10.0752 18.9807 8.68726V8.14226C18.9807 7.96581 18.9406 7.79372 18.8647 7.62756C18.3435 8.76861 16.1245 9.62587 13.4659 9.62587Z"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
        custom("path") {
            attrs["fillRule"] = "evenodd"
            attrs["clipRule"] = "evenodd"
            attrs["d"] = "M13.4659 12.583C10.8074 12.583 8.58838 11.7257 8.06716 10.5847C7.99125 10.7509 7.95117 10.9229 7.95117 11.0993V11.6444C7.95117 13.0323 10.4202 14.1574 13.4659 14.1574C16.5116 14.1574 18.9807 13.0323 18.9807 11.6444V11.0993C18.9807 10.9229 18.9406 10.7508 18.8647 10.5847C18.3435 11.7256 16.1245 12.583 13.4659 12.583Z"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
        custom("path") {
            attrs["fillRule"] = "evenodd"
            attrs["clipRule"] = "evenodd"
            attrs["d"] = "M13.4659 15.3886C10.8074 15.3886 8.58838 14.5314 8.06716 13.3904C7.99125 13.5566 7.95117 13.7287 7.95117 13.905V14.45C7.95117 15.8379 10.4202 16.963 13.4659 16.963C16.5116 16.963 18.9807 15.8379 18.9807 14.45V13.905C18.9807 13.7286 18.9406 13.5564 18.8647 13.3903C18.3435 14.5313 16.1245 15.3886 13.4659 15.3886Z"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
    }
}

fun RBuilder.svgHangingCalendar(isActive: Boolean = false) {
    svg {
        attrs["width"] = "20"
        attrs["height"] = "19"
        attrs["viewBox"] = "0 0 20 19"
        custom("rect") {
            attrs["x"] = "6.54199"
            attrs["y"] = "6.02075"
            attrs["width"] = "2.66454"
            attrs["height"] = "2.72227"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
        custom("rect") {
            attrs["x"] = "10.7607"
            attrs["y"] = "6.02075"
            attrs["width"] = "2.66454"
            attrs["height"] = "2.72227"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
        custom("rect") {
            attrs["x"] = "14.9795"
            attrs["y"] = "6.02075"
            attrs["width"] = "2.66454"
            attrs["height"] = "2.72227"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
        custom("rect") {
            attrs["x"] = "2.32324"
            attrs["y"] = "10.1042"
            attrs["width"] = "2.66454"
            attrs["height"] = "2.72227"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
        custom("rect") {
            attrs["x"] = "6.54199"
            attrs["y"] = "10.1042"
            attrs["width"] = "2.66454"
            attrs["height"] = "2.72227"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
        custom("rect") {
            attrs["x"] = "10.7607"
            attrs["y"] = "10.1042"
            attrs["width"] = "2.66454"
            attrs["height"] = "2.72227"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
        custom("rect") {
            attrs["x"] = "14.9795"
            attrs["y"] = "10.1042"
            attrs["width"] = "2.66454"
            attrs["height"] = "2.72227"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
        custom("rect") {
            attrs["x"] = "2.32324"
            attrs["y"] = "14.1877"
            attrs["width"] = "2.66454"
            attrs["height"] = "2.72203"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
        custom("rect") {
            attrs["x"] = "6.54199"
            attrs["y"] = "14.1877"
            attrs["width"] = "2.66454"
            attrs["height"] = "2.72203"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
        custom("rect") {
            attrs["x"] = "10.7607"
            attrs["y"] = "14.1877"
            attrs["width"] = "2.66454"
            attrs["height"] = "2.72203"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
        custom("path") {
            attrs["fillRule"] = "evenodd"
            attrs["clipRule"] = "evenodd"
            attrs["d"] = "M18.6351 0.0217285H1.33227C0.596705 0.0217285 0 0.631162 0 1.38266V4.59616H19.9674V1.38266C19.9674 0.631162 19.3707 0.0217285 18.6351 0.0217285ZM5.03635 3.53613C4.48467 3.53613 4.03716 3.07893 4.03716 2.5153C4.03716 1.95146 4.48467 1.49446 5.03635 1.49446C5.58822 1.49446 6.03533 1.95126 6.03533 2.5153C6.03533 3.0789 5.58822 3.53613 5.03635 3.53613ZM13.932 2.5153C13.932 3.07893 14.3795 3.53613 14.9314 3.53613C15.4831 3.53613 15.9302 3.0789 15.9302 2.5153C15.9302 1.95126 15.4831 1.49446 14.9314 1.49446C14.3795 1.49446 13.932 1.95146 13.932 2.5153Z"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
        custom("path") {
            attrs["fillRule"] = "evenodd"
            attrs["clipRule"] = "evenodd"
            attrs["d"] = "M19.0792 17.6174C19.0792 17.8676 18.8802 18.0711 18.6351 18.0711H1.33227C1.08741 18.0711 0.888189 17.8676 0.888189 17.6174V5.91626H0V17.6174C0 18.3691 0.596476 18.9786 1.33227 18.9786H18.6351C19.3707 18.9786 19.9674 18.3692 19.9674 17.6174V5.91626H19.0794V17.6174H19.0792Z"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
    }
}

fun RBuilder.svgStudents(isActive: Boolean = false) {
    svg {
        attrs["width"] = "20"
        attrs["height"] = "20"
        attrs["viewBox"] = "0 0 20 20"
        custom("path") {
            attrs["fillRule"] = "evenodd"
            attrs["clipRule"] = "evenodd"
            attrs["d"] = "M0.713867 20H5.71387V18.1482C5.71387 17.5346 5.23413 17.037 4.64244 17.037H1.7853C1.1936 17.037 0.713867 17.5346 0.713867 18.1482V20Z"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
        custom("path") {
            attrs["fillRule"] = "evenodd"
            attrs["clipRule"] = "evenodd"
            attrs["d"] = "M7.5 20H12.5V18.1482C12.5 17.5346 12.0203 17.037 11.4286 17.037H8.57143C7.97974 17.037 7.5 17.5346 7.5 18.1482V20Z"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
        custom("path") {
            attrs["fillRule"] = "evenodd"
            attrs["clipRule"] = "evenodd"
            attrs["d"] = "M14.2861 20H19.2861V18.1482C19.2861 17.5346 18.8064 17.037 18.2147 17.037H15.3576C14.7659 17.037 14.2861 17.5346 14.2861 18.1482V20Z"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
        custom("path") {
            attrs["fillRule"] = "evenodd"
            attrs["clipRule"] = "evenodd"
            attrs["d"] = "M17.8567 14.8148C17.8567 15.4284 17.377 15.9259 16.7853 15.9259C16.1936 15.9259 15.7139 15.4284 15.7139 14.8148C15.7139 14.2012 16.1936 13.7037 16.7853 13.7037C17.377 13.7037 17.8567 14.2012 17.8567 14.8148Z"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
        custom("path") {
            attrs["fillRule"] = "evenodd"
            attrs["clipRule"] = "evenodd"
            attrs["d"] = "M20 0H0V14.0741H1.57994C1.86297 13.3993 2.50488 12.963 3.21429 12.963C3.92369 12.963 4.5656 13.3993 4.84863 14.0741H8.36565C8.64868 13.3993 9.2906 12.963 10 12.963C10.7094 12.963 11.3513 13.3993 11.6343 14.0741H15.1514C15.4344 13.3993 16.0763 12.963 16.7857 12.963C17.4951 12.963 18.137 13.3993 18.4201 14.0741H20V0ZM7.5 1.5889L14.3 5.55556L7.5 9.52221V1.5889ZM0.714286 12.2222H2.5V11.4815H0.714286V12.2222ZM3.57143 12.5926H2.85714V11.1111H3.57143V12.5926ZM3.92857 12.2222H19.2857V11.4815H3.92857V12.2222Z"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
        custom("path") {
            attrs["fillRule"] = "evenodd"
            attrs["clipRule"] = "evenodd"
            attrs["d"] = "M8.21387 2.85553V8.25556L12.8424 5.55554L8.21387 2.85553Z"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
        custom("path") {
            attrs["fillRule"] = "evenodd"
            attrs["clipRule"] = "evenodd"
            attrs["d"] = "M11.0716 14.8148C11.0716 15.4284 10.5918 15.9259 10.0001 15.9259C9.40845 15.9259 8.92871 15.4284 8.92871 14.8148C8.92871 14.2012 9.40845 13.7037 10.0001 13.7037C10.5918 13.7037 11.0716 14.2012 11.0716 14.8148Z"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
        custom("path") {
            attrs["fillRule"] = "evenodd"
            attrs["clipRule"] = "evenodd"
            attrs["d"] = "M4.28544 14.8148C4.28544 15.4284 3.8057 15.9259 3.21401 15.9259C2.62231 15.9259 2.14258 15.4284 2.14258 14.8148C2.14258 14.2012 2.62231 13.7037 3.21401 13.7037C3.8057 13.7037 4.28544 14.2012 4.28544 14.8148Z"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
    }
}

fun RBuilder.svgWorld(isActive: Boolean = false) {
    svg {
        attrs["width"] = "20"
        attrs["height"] = "20"
        attrs["viewBox"] = "0 0 20 20"
        custom("path") {
            attrs["fillRule"] = "evenodd"
            attrs["clipRule"] = "evenodd"
            attrs["d"] = "M17.9716 4.35498L17.6779 4.44811L16.1135 4.58748L15.6716 5.29311L15.351 5.19123L14.106 4.06873L13.9254 3.48498L13.6835 2.86248L12.901 2.16061L11.9779 1.97998L11.9566 2.40248L12.861 3.28498L13.3035 3.80623L12.806 4.06623L12.401 3.94686L11.7941 3.69373L11.8147 3.20436L11.0185 2.87686L10.7541 4.02748L9.9516 4.20936L10.031 4.85123L11.0766 5.05248L11.2572 4.02686L12.1204 4.15436L12.5216 4.38936H13.1654L13.606 5.27186L14.7741 6.45686L14.6885 6.91748L13.7466 6.79748L12.1191 7.61936L10.9472 9.02498L10.7947 9.64748H10.3741L9.59035 9.28623L8.8291 9.64748L9.01848 10.4506L9.34973 10.0687L9.93223 10.0506L9.8916 10.7719L10.3741 10.9131L10.856 11.4544L11.6429 11.2331L12.5416 11.375L13.5854 11.6556L14.1066 11.7169L14.9904 12.72L16.696 13.7231L15.5929 15.8306L14.4285 16.3719L13.9866 17.5762L12.3016 18.7012L12.1222 19.35C16.4297 18.3125 19.6341 14.4431 19.6341 9.81686C19.6329 7.79623 19.0204 5.91561 17.9716 4.35498Z"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
        custom("path") {
            attrs["fillRule"] = "evenodd"
            attrs["clipRule"] = "evenodd"
            attrs["d"] = "M10.9473 14.9481L10.2323 13.6225L10.8886 12.255L10.2323 12.0588L9.49543 11.3188L7.86293 10.9525L7.32105 9.81877V10.4919H7.0823L5.67543 8.58439V7.01752L4.64418 5.34064L3.00668 5.63252H1.90355L1.34855 5.26877L2.05668 4.70752L1.35043 4.87064C0.49918 6.32439 0.00292969 8.01127 0.00292969 9.81814C0.00292969 15.2388 4.39731 19.635 9.81855 19.635C10.2361 19.635 10.6454 19.5981 11.0504 19.5494L10.9479 18.36C10.9479 18.36 11.3986 16.5938 11.3986 16.5338C11.3979 16.4731 10.9473 14.9481 10.9473 14.9481Z"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
        custom("path") {
            attrs["fillRule"] = "evenodd"
            attrs["clipRule"] = "evenodd"
            attrs["d"] = "M3.64957 3.16563L5.39332 2.9225L6.19707 2.48187L7.10145 2.7425L8.54645 2.6625L9.04145 1.88437L9.76332 2.00312L11.5164 1.83875L11.9996 1.30625L12.6808 0.85125L13.6446 0.99625L13.9958 0.943125C12.7264 0.345625 11.3139 0 9.81707 0C6.7702 0 4.04582 1.38875 2.24707 3.56938H2.25207L3.64957 3.16563ZM10.2321 0.97625L11.2346 0.424375L11.8783 0.79625L10.9464 1.50563L10.0564 1.595L9.65582 1.335L10.2321 0.97625ZM7.7052 1.24125L7.2627 1.05687C7.24916 1.16696 6.69 1.53267 6.6256 1.57479C6.62162 1.57738 6.61953 1.57875 6.61957 1.57875L7.2627 1.955L8.6002 1.60375L8.28457 1.05687L7.7052 1.24125Z"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
    }
}

fun RBuilder.svgRemoveIcon() {
    svg {
        attrs["width"] = "54"
        attrs["height"] = "54"
        attrs["viewBox"] = "0 0 54 54"
        attrs["fill"] = "none"
        custom("g") {
            attrs["opacity"] = "0.303908"
            attrs["filter"] = "url(#filter0_d)"
            custom("rect") {
                attrs["x"] = "146"
                attrs["y"] = "30"
                attrs["width"] = "34"
                attrs["height"] = "34"
                attrs["rx"] = "2"
                attrs["fill"] = "black"
            }
        }
        custom("path") {
            attrs["fillRule"] = "evenodd"
            attrs["clipRule"] = "evenodd"
            attrs["d"] = "M32.0676 20.5823C32.4581 20.1918 32.4581 19.5586 32.0676 19.1681L31.8319 18.9324C31.4414 18.5419 30.8082 18.5419 30.4177 18.9324L27 22.3501L23.5823 18.9324C23.1918 18.5419 22.5586 18.5419 22.1681 18.9324L21.9324 19.1681C21.5419 19.5586 21.5419 20.1918 21.9324 20.5823L25.3501 24L21.9324 27.4177C21.5419 27.8082 21.5419 28.4414 21.9324 28.8319L22.1681 29.0676C22.5586 29.4581 23.1918 29.4581 23.5823 29.0676L27 25.6499L30.4177 29.0676C30.8082 29.4581 31.4414 29.4581 31.8319 29.0676L32.0676 28.8319C32.4581 28.4414 32.4581 27.8082 32.0676 27.4177L28.6499 24L32.0676 20.5823Z"
            attrs["fill"] = "white"
        }
        custom("defs") {
            custom("filter") {
                attrs["id"] = "filter0_d"
                attrs["x"] = "0"
                attrs["y"] = "0"
                attrs["width"] = "54"
                attrs["height"] = "54"
                attrs["filterUnits"] = "userSpaceOnUse"
                attrs["color-interpolation-filters"] = "sRGB"
                custom("feFlood") {
                    attrs["flood-opacity"] = "0"
                    attrs["result"] = "BackgroundImageFix"
                }
                custom("feColorMatrix") {
                    attrs["in"] = "SourceAlpha"
                    attrs["type"] = "matrix"
                    attrs["values"] = "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 127 0"
                }
                custom("feOffset") {
                    attrs["dy"] = "3"
                }
                custom("feGaussianBlur") {
                    attrs["stdDeviation"] = "5"
                }
                custom("feColorMatrix") {
                    attrs["type"] = "matrix"
                    attrs["values"] = "0 0 0 0 0.14902 0 0 0 0 0.490196 0 0 0 0 0.807843 0 0 0 0.15 0"
                }
                custom("feBlend") {
                    attrs["mode"] = "normal"
                    attrs["in2"] = "BackgroundImageFix"
                    attrs["result"] = "effect1_dropShadow"
                }
                custom("feBlend") {
                    attrs["mode"] = "normal"
                    attrs["in"] = "SourceGraphic"
                    attrs["in2"] = "effect1_dropShadow"
                    attrs["result"] = "shape"
                }
            }
        }
    }
}

fun RBuilder.svgLogoProfileNotifications(isActive: Boolean = false) {
    svg {
        attrs["width"] = "20"
        attrs["height"] = "20"
        attrs["viewBox"] = "0 0 20 20"
        custom("g") {
            attrs["fill"] = "19993C"
            attrs["fillRule"] = "nonzero"
            custom("path") {
                attrs["d"] = "M10.004 10.598c2.465 0 4.464-2.362 4.464-5.276 0-4.042-1.998-5.277-4.464-5.277S5.54 1.28 5.54 5.322c0 2.914 1.998 5.276 4.464 5.276zM19.862 18.364l-2.252-5.123a1.137 1.137 0 0 0-.51-.547l-3.495-1.838a.223.223 0 0 0-.24.02 5.503 5.503 0 0 1-3.361 1.155c-1.21 0-2.373-.4-3.361-1.154a.224.224 0 0 0-.24-.02l-3.495 1.837a1.137 1.137 0 0 0-.51.547L.146 18.364c-.155.354-.123.758.085 1.082.209.324.562.517.944.517h17.658c.382 0 .735-.193.944-.517.208-.324.24-.728.085-1.082z"
                attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
            }
        }
    }
}

fun RBuilder.svgLogoReports(isActive: Boolean = false) {
    svg {
        attrs["width"] = "20"
        attrs["height"] = "20"
        attrs["viewBox"] = "0 0 20 20"
        custom("defs") {
            custom("path") {
                attrs["id"] = "b"
                attrs["d"] = "M10.004 10.598c2.465 0 4.464-2.362 4.464-5.276 0-4.042-1.998-5.277-4.464-5.277S5.54 1.28 5.54 5.322c0 2.914 1.998 5.276 4.464 5.276zM19.862 18.364l-2.252-5.123a1.137 1.137 0 0 0-.51-.547l-3.495-1.838a.223.223 0 0 0-.24.02 5.503 5.503 0 0 1-3.361 1.155c-1.21 0-2.373-.4-3.361-1.154a.224.224 0 0 0-.24-.02l-3.495 1.837a1.137 1.137 0 0 0-.51.547L.146 18.364c-.155.354-.123.758.085 1.082.209.324.562.517.944.517h17.658c.382 0 .735-.193.944-.517.208-.324.24-.728.085-1.082z"
                attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
            }
            custom("filter") {
                attrs["id"] = "a"
                attrs["width"] = "200%"
                attrs["height"] = "200%"
                attrs["x"] = "-50%"
                attrs["y"] = "-50%"
                attrs["filterUnits"] = "objectBoundingBox"
                attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
                custom("feOffset") {
                    attrs["in"] = "SourceAlpha"
                    attrs["result"] = "shadowOffsetOuter1"
                    attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
                }
                custom("feGaussianBlur") {
                    attrs["in"] = "shadowOffsetOuter1"
                    attrs["result"] = "shadowBlurOuter1"
                    attrs["stdDeviation"] = "10"
                    attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
                }
                custom("feColorMatrix") {
                    attrs["in"] = "shadowBlurOuter1"
                    attrs["values"] = "0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0.1 0"
                    attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
                }
            }
        }
        custom("g") {
            attrs["fill"] = "#19993C"
            attrs["fillRule"] = "nonzero"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
            custom("path") {
                attrs["d"] = "M13 0v5h5z"
                attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
            }
            custom("path") {
                attrs["d"] = "M13 6.25c-.826 0-1.5-.561-1.5-1.25V0h-9C1.673 0 1 .561 1 1.25v17.5c0 .69.673 1.25 1.5 1.25h15c.828 0 1.5-.56 1.5-1.25V6.25h-6zM7 17.5H4v-3.75h3v3.75zm4.5 0h-3v-6.25h3v6.25zm4.5 0h-3V8.75h3v8.75z"
                attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
            }
        }
    }
}

fun RBuilder.svgDashboard(isActive: Boolean = false) {
    svg {
        attrs["width"] = "20"
        attrs["height"] = "20"
        attrs["viewBox"] = "0 0 20 20"
        attrs["fill"] = "none"
        custom("path") {
            attrs["d"] = "M7.70828 0H1.45828C0.654144 0 0 0.654144 0 1.45828V5.20828C0 6.01257 0.654144 6.66672 1.45828 6.66672H7.70828C8.51257 6.66672 9.16672 6.01257 9.16672 5.20828V1.45828C9.16672 0.654144 8.51257 0 7.70828 0Z"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
        custom("path") {
            attrs["d"] = "M7.70828 8.3335H1.45828C0.654144 8.3335 0 8.98764 0 9.79193V18.5419C0 19.3461 0.654144 20.0002 1.45828 20.0002H7.70828C8.51257 20.0002 9.16672 19.3461 9.16672 18.5419V9.79193C9.16672 8.98764 8.51257 8.3335 7.70828 8.3335Z"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
        custom("path") {
            attrs["d"] = "M18.5417 13.3335H12.2917C11.4874 13.3335 10.8333 13.9876 10.8333 14.7919V18.5419C10.8333 19.3461 11.4874 20.0002 12.2917 20.0002H18.5417C19.3458 20.0002 20 19.3461 20 18.5419V14.7919C20 13.9876 19.3458 13.3335 18.5417 13.3335V13.3335Z"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
        custom("path") {
            attrs["d"] = "M18.5417 0H12.2917C11.4874 0 10.8333 0.654144 10.8333 1.45828V10.2083C10.8333 11.0126 11.4874 11.6667 12.2917 11.6667H18.5417C19.3458 11.6667 20 11.0126 20 10.2083V1.45828C20 0.654144 19.3458 0 18.5417 0V0Z"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
    }
}

fun RBuilder.svgClients(isActive: Boolean = false) {
    svg {
        attrs["width"] = "20"
        attrs["height"] = "20"
        attrs["viewBox"] = "0 0 20 20"
        attrs["fill"] = "none"
        custom("path") {
            attrs["d"] = "M9.99998 4.99025C11.3753 4.99025 12.4902 3.87315 12.4902 2.49513C12.4902 1.11711 11.3753 0 9.99998 0C8.62464 0 7.5097 1.11711 7.5097 2.49513C7.5097 3.87315 8.62464 4.99025 9.99998 4.99025Z"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
        custom("path") {
            attrs["d"] = "M13.7304 11.772L13.1651 7.3606C13.1016 6.7206 12.5687 6.23779 11.9274 6.23779H11.2451C11.0795 6.23779 10.9213 6.30391 10.8043 6.41994L9.99994 7.22586L9.19558 6.41994C9.07854 6.30391 8.92041 6.23779 8.7548 6.23779H8.07371C7.43122 6.23779 6.8983 6.7206 6.83605 7.34438L6.26951 11.7732C6.2471 11.9504 6.30188 12.13 6.42017 12.2635C6.53846 12.3983 6.7078 12.4756 6.8871 12.4756H7.55947L8.07994 18.8382C8.1422 19.4769 8.67636 19.961 9.31885 19.961H10.6823C11.3248 19.961 11.8577 19.4769 11.9224 18.827L12.4417 12.4756H13.1128C13.2921 12.4756 13.4614 12.3983 13.5797 12.2635C13.6992 12.13 13.754 11.9504 13.7304 11.772Z"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
        custom("path") {
            attrs["d"] = "M16.2256 4.99025C17.601 4.99025 18.7159 3.87315 18.7159 2.49513C18.7159 1.11711 17.601 0 16.2256 0C14.8503 0 13.7354 1.11711 13.7354 2.49513C13.7354 3.87315 14.8503 4.99025 16.2256 4.99025Z"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
        custom("path") {
            attrs["d"] = "M3.77427 0C2.40088 0 1.284 1.11906 1.284 2.49513C1.284 3.87119 2.40088 4.99025 3.77427 4.99025C5.14641 4.99025 6.26454 3.87119 6.26454 2.49513C6.26454 1.11906 5.14641 0 3.77427 0Z"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
        custom("path") {
            attrs["d"] = "M19.9561 11.772L19.3908 7.36185C19.3273 6.7206 18.7956 6.23779 18.1531 6.23779H17.4708C17.3052 6.23779 17.147 6.30391 17.03 6.41994L16.2256 7.22586L15.4213 6.41994C15.3042 6.30391 15.1461 6.23779 14.9817 6.23779H14.2994C14.2222 6.23779 14.1525 6.26524 14.079 6.27896C14.2396 6.56341 14.3654 6.87156 14.4028 7.21713L14.9668 11.6135C15.0365 12.1487 14.8697 12.6877 14.5111 13.0932C14.3417 13.2878 14.1251 13.425 13.8935 13.5323L14.3069 17.5906C14.3704 18.2306 14.9033 18.7134 15.5458 18.7134H16.9092C17.5517 18.7134 18.0846 18.2294 18.1494 17.5794L18.6673 12.4756H19.3385C19.5178 12.4756 19.6871 12.3983 19.8054 12.2635C19.9249 12.13 19.9797 11.9504 19.9561 11.772Z"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
        custom("path") {
            attrs["d"] = "M5.48509 13.0869C5.13147 12.6864 4.96711 12.1487 5.03435 11.616L5.60088 7.18594C5.63326 6.85409 5.75528 6.55467 5.91092 6.27771C5.8412 6.26524 5.7752 6.23779 5.70174 6.23779H5.01941C4.8538 6.23779 4.69567 6.30391 4.57863 6.41994L3.77427 7.22586L2.96991 6.41994C2.85287 6.30391 2.69474 6.23779 2.53038 6.23779H1.848C1.20551 6.23779 0.672596 6.7206 0.610339 7.34438L0.0438023 11.7732C0.0213898 11.9504 0.0761758 12.13 0.194464 12.2635C0.312752 12.3983 0.483335 12.4756 0.66139 12.4756H1.33376L1.85423 17.5906C1.91649 18.2294 2.45065 18.7134 3.09314 18.7134H4.45656C5.09906 18.7134 5.63197 18.2294 5.69672 17.5794L6.11011 13.531C5.8773 13.4225 5.65941 13.284 5.48509 13.0869Z"
            attrs["fill"] = if (isActive) "#19993C" else "#D2DCE9"
        }
    }
}