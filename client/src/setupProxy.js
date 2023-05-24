const { createProxyMiddleware } = require('http-proxy-middleware');

const proxy = {
    target: process.env.proxy,
    changeOrigin: true
}

module.exports = function(app) {
    app.use(
        '/api',
        createProxyMiddleware(proxy)
    );
};