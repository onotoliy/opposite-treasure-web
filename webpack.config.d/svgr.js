config.module.rules.push(
    {
        test: /\.svg$/,
        use: [
            {
                loader: '@svgr/webpack',
                options: {
                    replaceAttrValues: {
                        '#697079': "{props.fillcolor}"
                    }
                }
            }
        ]
    }
);